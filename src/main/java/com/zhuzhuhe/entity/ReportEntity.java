package com.zhuzhuhe.entity;

import com.deepoove.poi.data.PictureRenderData;
import com.zhuzhuhe.util.CheckProgramEnum;
import lombok.Data;
import org.apache.poi.ss.usermodel.PictureData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 琦哥 on 2020/1/4.
 */
@Data
public class ReportEntity implements Serializable{
    private static final long serialVersionUID = -4683590597060494958L;

    private String name;//姓名
    private String sampleType;//样本类型
    private String sampleCharacter;//样本性状
    private String submitUnit;//送检单位
    private String hospitalNum;//住院号
    private String sex;//性别
    private String age;//年龄
    private String submitDoctor;//送检医师
    private String bedNum;//床号
    private String branch;//科别
    private String receiveTime;//接收时间
    private String collectTime;//采集时间
    private String clinicaliagnosis;//临床诊断
    private List<String> results ;//结果
    private List<PictureData> pics;//图片
    private List<String> picsPath;//图片路径
    private String local;//地区
    private String checkProgram;//检测项目
    private String reportTime;//报告时间
    private String barCode;//报告时间
    private CheckProgramEnum checkProgramEnum;//枚举类
    private String idNum;//excel行号

}
