package com.zhuzhuhe.service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureRenderData;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.zhuzhuhe.entity.ReportEntity;
import com.zhuzhuhe.util.CheckProgramEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.PictureData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 琦哥 on 2020/1/5.
 */
public class CreateReportServiceImpl {

    public void createReport(ReportEntity reportEntity) {
        Map<String, Object> map = new HashMap<>();
        try {
            String reportTime = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
            String docTime = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDateTime.now());
            map.put("name", reportEntity.getName());
            map.put("sampleType", reportEntity.getSampleType());
            map.put("sampleCharacter", reportEntity.getSampleCharacter());
            map.put("submitUnit", reportEntity.getSubmitUnit());
            map.put("hospitalNum", reportEntity.getHospitalNum());
            map.put("sex", reportEntity.getSex());
            map.put("age", reportEntity.getAge());
            map.put("submitDoctor", reportEntity.getSubmitDoctor());
            map.put("bedNum", reportEntity.getBedNum());
            map.put("branch", reportEntity.getBranch());
            map.put("receiveTime", reportEntity.getReceiveTime());
            map.put("collectTime", reportEntity.getCollectTime());
            map.put("clinicaliagnosis", reportEntity.getClinicaliagnosis());
            map.put("reportTime", reportTime);
            CheckProgramEnum checkProgramEnum = reportEntity.getCheckProgramEnum();

            //检测结果处理
            for (int i = 0; i < checkProgramEnum.getProgramName().length; i++) {
                if (null != reportEntity.getResults() && reportEntity.getResults().size() > 0 && startWith(reportEntity.getResults(), String.valueOf(i))) {
                    List<String> results = reportEntity.getResults();
                    String s = null;
                    for (String result : results) {
                        if(result.startsWith(String.valueOf(i))){
                            s = result;
                            break;
                        }
                    }
                    if(s.contains("(")&&s.contains(")")){
                        String substring = s.substring(s.indexOf("(")+1, s.indexOf(")"));
                        map.put("result" + i, substring);
                    }else {
                        map.put("result" + i, "+");
                    }
                } else {
                    map.put("result" + i, "阴性");
                }
            }

            //图片处理
            for (int i = 0; i < checkProgramEnum.getPicNum(); i++) {
                if (null != reportEntity.getPicsPath() && reportEntity.getPicsPath().size() > i) {
                    map.put("pics" + i, new PictureRenderData(250, 155, reportEntity.getPicsPath().get(i)));
                }
            }

            //生成模板
            String rootTemplatePath = "template\\";
//            String rootTemplatePath = "D:\\all-moudle-demo-test\\out\\artifacts\\excel_word_pdf_jar\\template\\";
            String templatePath = rootTemplatePath + reportEntity.getCheckProgram() + ".docx";

            XWPFTemplate template = XWPFTemplate.compile(templatePath).render(map);
            String wordPath = "report\\" + reportEntity.getCheckProgram() + "报告."
                    + reportEntity.getName() + "." + reportEntity.getSex() + "." + reportEntity.getAge() + "."
                    + reportEntity.getSampleType() + "." + docTime;
//            String wordPath = "D:\\all-moudle-demo-test\\out\\artifacts\\excel_word_pdf_jar\\report\\" + reportEntity.getCheckProgram() + "报告."
//                    + reportEntity.getName() + "." + reportEntity.getSex() + "." + reportEntity.getAge() + "."
//                    + reportEntity.getSampleType() + "." + docTime;
            File file = new File(wordPath + ".docx");
            try {
                FileOutputStream out = new FileOutputStream(file);
                template.write(out);
                out.flush();
                out.close();
                template.close();
                System.out.println("成功生成报告：" + reportEntity.getBarCode() + ":" + reportEntity.getName());
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            //word转pdf
            ActiveXComponent app = null;
//            System.out.println(file.getAbsolutePath());
            String wordFile = file.getAbsolutePath();
//            String wordFile = wordPath + ".docx";
            String pdfFile = file.getAbsolutePath().replace(".docx", ".pdf");

//            System.out.println("开始转换...");
            // 开始时间
            long start = System.currentTimeMillis();
            try {
                // 打开word
                try {
                    app = new ActiveXComponent("Word.Application");
                } catch (Exception e) {
//                    e.printStackTrace();
                    app = new ActiveXComponent("KWPS.Application");
                }

                // 设置word不可见,很多博客下面这里都写了这一句话，其实是没有必要的，因为默认就是不可见的，如果设置可见就是会打开一个word文档，对于转化为pdf明显是没有必要的
                //app.setProperty("Visible", false);
                // 获得word中所有打开的文档
                Dispatch documents = app.getProperty("Documents").toDispatch();
//                System.out.println("打开文件: " + wordFile);
                // 打开文档
                Dispatch document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();
                // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
                File target = new File(pdfFile);
                if (target.exists()) {
                    target.delete();
                }
                System.out.println("另存为: " + pdfFile);
                // 另存为，将文档报错为pdf，其中word保存为pdf的格式宏的值是17
                Dispatch.call(document, "SaveAs", pdfFile, 17);
                // 关闭文档
                Dispatch.call(document, "Close", false);
                // 结束时间
//                long end = System.currentTimeMillis();
//                System.out.println("转换成功，用时：" + (end - start) + "ms");
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
                System.out.println("转换失败" + e.getMessage());
                throw new RuntimeException(e);
            } finally {
                // 关闭office
                app.invoke("Quit", 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ReportEntity> excel2Entity(Map<Integer, Map<Integer, Object>> excelContent, List<? extends PictureData> allPictures) {
        List<ReportEntity> list = new ArrayList<>();
        try {
            int picNum = 0;
            for (Map.Entry<Integer, Map<Integer, Object>> integerMapEntry : excelContent.entrySet()) {
                ReportEntity reportEntity = new ReportEntity();
                String barCode = (String) integerMapEntry.getValue().get(0);
                String name = (String) integerMapEntry.getValue().get(1);
                String sex = (String) integerMapEntry.getValue().get(2);
                String age = (String) integerMapEntry.getValue().get(3);
                age = age.replace(".0", "");
                String local = (String) integerMapEntry.getValue().get(4);
                String checkProgram = (String) integerMapEntry.getValue().get(5);
                String sampleType = (String) integerMapEntry.getValue().get(6);
                String collectTime = (String) integerMapEntry.getValue().get(7);
                String submitUnit = (String) integerMapEntry.getValue().get(8);
                String hospitalNum = (String) integerMapEntry.getValue().get(9);
                hospitalNum = hospitalNum.replace(".0", "");
                String branch = (String) integerMapEntry.getValue().get(10);
                String bedNum = (String) integerMapEntry.getValue().get(11);
                bedNum = bedNum.replace(".0", "");
                String sampleCharacter = (String) integerMapEntry.getValue().get(12);
                String submitDoctor = (String) integerMapEntry.getValue().get(15);
                String clinicaliagnosis = (String) integerMapEntry.getValue().get(17);
                String results = (String) integerMapEntry.getValue().get(18);
                CheckProgramEnum checkProgramEnum = CheckProgramEnum.getCheckProgramEnum(checkProgram);
                if (null == checkProgramEnum) {
                    continue;
                }
                reportEntity.setIdNum(String.valueOf(integerMapEntry.getKey()));
                reportEntity.setCheckProgramEnum(checkProgramEnum);
                reportEntity.setBarCode(barCode);
                reportEntity.setName(name);
                reportEntity.setSex(sex);
                reportEntity.setAge(age);
                reportEntity.setLocal(local);
                reportEntity.setCheckProgram(checkProgram);
                reportEntity.setSampleType(sampleType);
                reportEntity.setCollectTime(collectTime);
                reportEntity.setReceiveTime(collectTime);
                reportEntity.setSubmitUnit(submitUnit);
                reportEntity.setHospitalNum(hospitalNum);
                reportEntity.setBranch(branch);
                reportEntity.setBedNum(bedNum);
                reportEntity.setSampleCharacter(sampleCharacter);
                reportEntity.setSubmitDoctor(submitDoctor);
                reportEntity.setClinicaliagnosis(clinicaliagnosis);
                //设置阳性检测结果
                if (StringUtils.isNotBlank(results)) {
                    List<String> checkRes = new ArrayList<>();
                    String[] programName = checkProgramEnum.getProgramName();
                    String[] split = results.split(",");
                    //O(n^2)待优化
                    for (int i = 0; i < programName.length; i++) {
                        for (String s : split) {
                            if (s.startsWith(programName[i])) {
                                checkRes.add(String.valueOf(i) + s);
                            }
                        }
                    }
                    reportEntity.setResults(checkRes);
                }


                //设置图片
                String picPath = "D:\\tmp\\";
                File file = new File(picPath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                List<PictureData> pictureData = new ArrayList<>();
                List<String> picsPath = new ArrayList<>();
                for (int i = 0; i < checkProgramEnum.getPicNum(); i++) {
                    if (picNum >= allPictures.size()) {
                        System.out.println("图片信息不全:" + reportEntity.getIdNum() + reportEntity.getName());
                        continue;
                    }
                    PictureData pictureData1 = allPictures.get(picNum);
                    pictureData.add(pictureData1);
                    try {
                        String onePath = picPath + reportEntity.getIdNum() + "-" + String.valueOf(i) + ".png";
                        FileOutputStream out = new FileOutputStream(onePath);
                        out.write(pictureData1.getData());
                        out.close();
                        picsPath.add(onePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    picNum++;
                }
                reportEntity.setPics(pictureData);
                reportEntity.setPicsPath(picsPath);

                list.add(reportEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean startWith(List<String> list, String i) {
        for (String s : list) {
            if (s.startsWith(i)) {
                return true;
            }
        }
        return false;
    }
}
