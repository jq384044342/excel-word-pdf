//package www.qige.word;
//
//import org.apache.commons.lang3.StringUtils;
//import www.qige.entity.TalnetEntity;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.util.*;
//
///**
// * Created by jiaqi on 2018/10/17 0017.
// */
//public class CreateReportAction extends JFrame implements ActionListener {
//    private Map<Integer, Map<Integer, Object>> personInfo;
//    private Map<Integer, Map<Integer, Object>> resultInfo;
//    private java.util.List<String> resultTime = new ArrayList<>();
//    java.util.List<TalnetEntity> reportList = new ArrayList<TalnetEntity>();
//    private Map<String, Map<Integer, Object>> resultMap = new HashMap<>();
//    JButton jbPerson = new JButton("导入个人信息");
//    JButton jbResult = new JButton("导入检测结果");
//    JButton jbReport = new JButton("生成报告");
//    private TalnetEntity attention;
//    private TalnetEntity creativity;
//    private TalnetEntity lang;
//
//    public CreateReportAction() {
//        jbPerson.setActionCommand("openPerson");
//        jbResult.setActionCommand("openResult");
//        jbReport.setActionCommand("createReport");
//        jbPerson.setBackground(Color.CYAN);//设置按钮颜色
//        jbResult.setBackground(Color.CYAN);//设置按钮颜色
//        jbReport.setBackground(Color.CYAN);//设置按钮颜色
//        jbPerson.setSize(20, 20);
//        jbResult.setSize(20, 20);
//        jbReport.setSize(20, 20);
//        //初始化一个文字区域
//
//        Container container = this.getContentPane();
//        container.setLayout(new FlowLayout());
//        container.add(jbPerson);//建立容器使用边界布局
//        container.add(jbResult);//建立容器使用边界布局
//        container.add(jbReport);//建立容器使用边界布局
//        //
//        jbPerson.addActionListener(this);
//        jbResult.addActionListener(this);
//        jbReport.addActionListener(this);
//        this.setTitle("天赋报告生成工具");
//        this.setSize(600, 400);
//        this.setLocation(200, 200);
//        //显示窗口true
//        this.setVisible(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("openPerson")) {
//            JFileChooser jf = new JFileChooser();
//            jf.showOpenDialog(this);//显示打开的文件对话框
//            File f = jf.getSelectedFile();//使用文件类获取选择器选择的文件
//            String path = f.getAbsolutePath();//返回路径名
//            ReadExcelUtils readExcelUtils = new ReadExcelUtils(path);
//            try {
//                personInfo = readExcelUtils.readExcelContent();
//                JOptionPane.showMessageDialog(this, "成功导入个人信息", "标题", JOptionPane.WARNING_MESSAGE);
//            } catch (Exception e1) {
//                JOptionPane.showMessageDialog(this, "导入个人信息错误", "标题", JOptionPane.WARNING_MESSAGE);
//                e1.printStackTrace();
//            }
//        } else if (e.getActionCommand().equals("openResult")) {
//            JFileChooser jf = new JFileChooser();
//            jf.showOpenDialog(this);//显示打开的文件对话框
//            File f = jf.getSelectedFile();//使用文件类获取选择器选择的文件
//            String path = f.getAbsolutePath();//返回路径名
//            ReadResultExcelUtils readExcelUtils = new ReadResultExcelUtils(path);
//            try {
//                //男性P53 rs1042522 APOE rs429358 女性 P53 rs1042522 MTHFR rs1801133
//                resultInfo = readExcelUtils.readExcelContent();
//                for (Map.Entry<Integer, Map<Integer, Object>> entry : resultInfo.entrySet()) {
//                    if (StringUtils.isNotEmpty((String) entry.getValue().get(0))
//                            &&StringUtils.isNotEmpty((String) entry.getValue().get(1))) {
//                        String num = (String) entry.getValue().get(0);
//                        if (num.contains(".0")) {
//                            num = num.replace(".0", "");
//                        }
//                        String geneNum = (String) entry.getValue().get(2);
//                        resultTime.add(num);
//                        resultMap.put(num + geneNum, entry.getValue());
//                    }
//                }
//                JOptionPane.showMessageDialog(this, "成功导入检测结果", "标题", JOptionPane.WARNING_MESSAGE);
//            } catch (Exception e1) {
//                JOptionPane.showMessageDialog(this, "导入检测结果错误", "标题", JOptionPane.WARNING_MESSAGE);
//                e1.printStackTrace();
//            }
//        } else if (e.getActionCommand().equals("createReport")) {
//            try {
//                for (Map.Entry<Integer, Map<Integer, Object>> entry : personInfo.entrySet()) {
//                    if (StringUtils.isNotEmpty((String) entry.getValue().get(1))) {
//                        TalnetEntity entity = new TalnetEntity();
//                        String num = (String) entry.getValue().get(2);
//                        if (num.contains(".0")) {
//                            num = num.replace(".0", "");
//                        }
//                        //检测结果含有某个编号的32个基因
//                        try {
//                            if (32 == Collections.frequency(resultTime, num)) {
//                                String theNum = (String) entry.getValue().get(2);
//                                String name = (String) entry.getValue().get(3);
//                                entity.setNum(theNum);
//                                entity.setName(name);
//                                entity.setSex((String) entry.getValue().get(4));
//                                entity.setAge((String) entry.getValue().get(5));
//                                entity.setFileName(theNum + name);
//                                setMemory(entity);
//                                entity.setMemoryResSug(getSug(entity.getMemoryRes(),""));
//                                entity.setMemoryResPic(getPic(entity.getMemoryRes(),""));
//                                setAttention(entity);
//                                entity.setAttentionResSug(getSug(entity.getAttentionRes(),""));
//                                entity.setAttentionResPic(getPic(entity.getAttentionRes(),""));
//                                setCreativity(entity);
//                                entity.setCreativityResSug(getSug(entity.getCreativityRes(),""));
//                                entity.setCreativityResPic(getPic(entity.getCreativityRes(),""));
//                                setLogical(entity);
//                                entity.setLogicalResSug(getSug(entity.getLogicalRes(),""));
//                                entity.setLogicalResPic(getPic(entity.getLogicalRes(),""));
//                                setLang(entity);
//                                entity.setLangResSug(getSug(entity.getLangRes(),""));
//                                entity.setLangResPic(getPic(entity.getLangRes(),""));
//                                setLearn(entity);
//                                entity.setLearnResSug(getSug(entity.getLearnRes(),""));
//                                entity.setLearnResPic(getPic(entity.getLearnRes(),""));
//                                setPrece(entity);
//                                entity.setPerceResSug(getSug(entity.getPerceRes(),""));
//                                entity.setPerceResPic(getPic(entity.getPerceRes(),""));
//                                setPaint(entity);
//                                entity.setPaintResSug(getSug(entity.getPaintRes(),""));
//                                entity.setPaintResPic(getPic(entity.getPaintRes(),""));
//                                setMusic(entity);
//                                entity.setMusicResSug(getSug(entity.getMusicRes(),""));
//                                entity.setMusicResPic(getPic(entity.getMusicRes(),""));
//                                setDance(entity);
//                                entity.setDanceResSug(getSug(entity.getDanceRes(),""));
//                                entity.setDanceResPic(getPic(entity.getDanceRes(),""));
//                                setEndurance(entity);
//                                entity.setEnduranceResSug(getSug(entity.getEnduranceRes(),""));
//                                entity.setEnduranceResPic(getPic(entity.getEnduranceRes(),""));
//                                setSpeed(entity);
//                                entity.setSpeedResSug(getSug(entity.getSpeedRes(),""));
//                                entity.setSpeedResPic(getPic(entity.getSpeedRes(),""));
//                                setLead(entity);
//                                entity.setLeadResSug(getSug(entity.getLeadRes(),""));
//                                entity.setLeadResPic(getPic(entity.getLeadRes(),""));
//                                setStress(entity);
//                                entity.setStressResSug(getSug(entity.getStressRes(),""));
//                                entity.setStressResPic(getPic(entity.getStressRes(),""));
//                                setEmpathy(entity);
//                                entity.setEmpathyResSug(getSug(entity.getEmpathyRes(),""));
//                                entity.setEmpathyResPic(getPic(entity.getEmpathyRes(),""));
//                                setTreason(entity);
//                                entity.setTreasonResSug(getSug(entity.getTreasonRes(),"risk"));
//                                entity.setTreasonResPic(getPic(entity.getTreasonRes(),"risk"));
//                                setHighMyopia(entity);
//                                entity.setHighMyopiaResSug(getSug(entity.getHighMyopiaRes(),"risk"));
//                                entity.setHighMyopiaResPic(getPic(entity.getHighMyopiaRes(),"risk"));
//                                setLip(entity);
//                                entity.setLipResSug(getSug(entity.getLipRes(),""));
//                                entity.setLipResPic(getPic(entity.getLipRes(),""));
//                                setWater(entity);
//                                entity.setWaterResSug(getSug(entity.getWaterRes(),""));
//                                entity.setWaterResPic(getPic(entity.getWaterRes(),""));
//                                setChess(entity);
//                                entity.setChessResSug(getSug(entity.getChessRes(),""));
//                                entity.setChessResPic(getPic(entity.getChessRes(),""));
//                                setBusiness(entity);
//                                entity.setBusinessResSug(getSug(entity.getBusinessRes(),""));
//                                entity.setBusinessResPic(getPic(entity.getBusinessRes(),""));
//                                setScientist(entity);
//                                entity.setScientistResSug(getSug(entity.getScientistRes(),""));
//                                entity.setScientistResPic(getPic(entity.getScientistRes(),""));
//                                reportList.add(entity);
//                            }
//                        } catch (Exception e1) {
//                            System.out.println("信息不匹配跳过生成报告"+entity.getNum()+entity.getName());
//                            e1.printStackTrace();
//                            continue;
//                        }
//                    }
//                }
//                for (TalnetEntity entity : reportList) {
//                    CreateWordReportImpl createWordReport = new CreateWordReportImpl();
//                    createWordReport.createReport(entity);
//                }
//                JOptionPane.showMessageDialog(this, "成功生成报告", "标题",JOptionPane.WARNING_MESSAGE);
//            } catch (Exception e1) {
//                JOptionPane.showMessageDialog(this, "生成报告错误", "标题", JOptionPane.WARNING_MESSAGE);
//                e1.printStackTrace();
//            }
//        }
//    }
//
//    private String getPic(double entity, String type) {
//        String res = "";
//        if ("risk".equals(type)) {
//            if (entity == 1) {
//                res = "正常";
//            } else if (entity > 1 && entity <= 2) {
//                res = "较高";
//            } else if (entity > 2 && entity <= 3) {
//                res = "高";
//            }
//            return res;
//        }
//        if (entity == 1) {
//            res = "low.png";
//        } else if (entity > 1 && entity <= 2) {
//            res = "mid.png";
//        } else if (entity > 2 && entity <= 3) {
//            res = "high.png";
//        }
//        return res;
//    }
//
//    private String getSug(double entity, String type) {
//        String res = "";
//        if ("risk".equals(type)) {
//            if (entity == 1) {
//                res = "正常";
//            } else if (entity > 1 && entity <= 2) {
//                res = "较高";
//            } else if (entity > 2 && entity <= 3) {
//                res = "高";
//            }
//            return res;
//        }
//        if (entity == 1) {
//            res = type+"一般";
//        } else if (entity > 1 && entity <= 2) {
//            res = type+"良好";
//        } else if (entity > 2 && entity <= 3) {
//            res = type+"优秀";
//        }
//        return res;
//    }
//
//    private double getRes(HashMap<String,String> stringStringHashMap) {
//        double res;
//        double sum = 0;
//        for (Map.Entry<String, String> entry : stringStringHashMap.entrySet()) {
//            String key = entry.getKey().substring(1,entry.getKey().length());
//            String value = entry.getValue();
//            if (key.length() == 1 && key.equals(value.substring(0, 1)) || key.equals(value)) {
//                sum += 3d;
//            } else if (key.contains(value.substring(0, 1))) {
//                sum += 2d;
//            } else {
//                sum += 1d;
//            }
//        }
//        res = sum / stringStringHashMap.size();
////        res = Math.round(res * 100) / 100;
//        return res;
//    }
//
//    //BDNF X2 rs6265 GG  WWC1 X3 rs17070145 TT
//    private void setMemory(TalnetEntity entity) {
//        entity.setX2((String) resultMap.get(entity.getNum() + "rs6265").get(1));
//        entity.setX3((String) resultMap.get(entity.getNum() + "rs17070145").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX2(), "GG");
//        stringStringHashMap.put("2"+entity.getX3(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setMemoryRes(res);
//    }
//
//    //    COMT rs4680 注意力 GG GIT1 rs550818 注意力 GG
//    public void setAttention(TalnetEntity entity) {
//        entity.setX15((String) resultMap.get(entity.getNum() + "rs4680").get(1));
//        entity.setX16((String) resultMap.get(entity.getNum() + "rs550818").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX15(), "GG");
//        stringStringHashMap.put("2"+entity.getX16(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setAttentionRes(res);
//    }
//
//    //x1 ANKK1 rs1800497 创造力
//    public void setCreativity(TalnetEntity entity) {
//        entity.setX1((String) resultMap.get(entity.getNum() + "rs1800497").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX1(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setCreativityRes(res);
//    }
//
//    //x4 x7 x8 CHRM2 rs324650 TT ARID1B rs12199332 GG FAM43A rs789859 CC 逻辑思维能力
//    public void setLogical(TalnetEntity entity) {
//        entity.setX4((String) resultMap.get(entity.getNum() + "rs324650").get(1));
//        entity.setX7((String) resultMap.get(entity.getNum() + "rs12199332").get(1));
//        entity.setX8((String) resultMap.get(entity.getNum() + "rs789859").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX4(), "TT");
//        stringStringHashMap.put("2"+entity.getX7(), "GG");
//        stringStringHashMap.put("3"+entity.getX8(), "CC");
//        double res = getRes(stringStringHashMap);
//        entity.setLogicalRes(res);
//    }
//
//    //语言能力 x10 x11 x12 x13 x14  CCDC136/FLNC rs59197085 GG NCAN rs1064395  GG
////DYX1C1 rs57809907  CC CACNA1C rs1006737  GG KIAA0319 rs4504469  GG
//    public void setLang(TalnetEntity entity) {
//        entity.setX10((String) resultMap.get(entity.getNum() + "rs59197085").get(1));
//        entity.setX11((String) resultMap.get(entity.getNum() + "rs1064395").get(1));
//        entity.setX12((String) resultMap.get(entity.getNum() + "rs57809907").get(1));
//        entity.setX13((String) resultMap.get(entity.getNum() + "rs1006737").get(1));
//        entity.setX14((String) resultMap.get(entity.getNum() + "rs4504469").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX10(), "GG");
//        stringStringHashMap.put("2"+entity.getX11(), "GG");
//        stringStringHashMap.put("3"+entity.getX12(), "CC");
//        stringStringHashMap.put("4"+entity.getX13(), "GG");
//        stringStringHashMap.put("5"+entity.getX14(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setLangRes(res);
//    }
//
//    //x9;//DBH rs1611115 学习能力 TT
//    public void setLearn(TalnetEntity entity) {
//        entity.setX9((String) resultMap.get(entity.getNum() + "rs1611115").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX10(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setLearnRes(res);
//    }
//
//    //x5;//SNAP25 rs363043 认知能力 TT
////    x6;//SNAP25 rs363050 认知能力 GG
//    public void setPrece(TalnetEntity entity) {
//        entity.setX5((String) resultMap.get(entity.getNum() + "rs363043").get(1));
//        entity.setX6((String) resultMap.get(entity.getNum() + "rs363050").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX5(), "TT");
//        stringStringHashMap.put("2"+entity.getX6(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setPerceRes(res);
//    }
//
//    //x2;//BDNF rs6265 记忆力 绘画能力 GG
////    x3;//WWC1 rs17070145 记忆力 绘画能力 TT
//    public void setPaint(TalnetEntity entity) {
//        entity.setX2((String) resultMap.get(entity.getNum() + "rs6265").get(1));
//        entity.setX3((String) resultMap.get(entity.getNum() + "rs17070145").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX2(), "GG");
//        stringStringHashMap.put("2"+entity.getX3(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setPaintRes(res);
//    }
//
//    //c1;//GATA2 rs4148254 音乐 TT
////    c2;//UGT8 rs9854612 音乐 GG
//    public void setMusic(TalnetEntity entity) {
//        entity.setC1((String) resultMap.get(entity.getNum() + "rs4148254").get(1));
//        entity.setC2((String) resultMap.get(entity.getNum() + "rs9854612").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getC1(), "TT");
//        stringStringHashMap.put("2"+entity.getC2(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setMusicRes(res);
//    }
//
//    //c4;//ACTN3 rs540874 舞蹈天赋 速度 TT
//    public void setDance(TalnetEntity entity) {
//        entity.setC4((String) resultMap.get(entity.getNum() + "rs540874").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getC4(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setDanceRes(res);
//    }
//
//    //c3;//PPP3CA rs1799971 耐力 TT
//    public void setEndurance(TalnetEntity entity) {
//        entity.setC3((String) resultMap.get(entity.getNum() + "rs1799971").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getC3(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setEnduranceRes(res);
//    }
//
//    //c4;//ACTN3 rs540874 舞蹈天赋 速度 TT
//    public void setSpeed(TalnetEntity entity) {
//        entity.setC4((String) resultMap.get(entity.getNum() + "rs540874").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put(entity.getC4(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setSpeedRes(res);
//    }
//
//    //L1;//CHRNB3 rs4950 天生领导力 GG
//    public void setLead(TalnetEntity entity) {
//        entity.setL1((String) resultMap.get(entity.getNum() + "rs4950").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getL1(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setLeadRes(res);
//    }
//
//    //    g1;//TNFRSF21 rs10948347 抗压能力 TT
////    g3;//OPRM1 rs1799971 抗压能力 GG
//    public void setStress(TalnetEntity entity) {
//        entity.setG1((String) resultMap.get(entity.getNum() + "rs10948347").get(1));
//        entity.setG3((String) resultMap.get(entity.getNum() + "rs1799971").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getG1(), "TT");
//        stringStringHashMap.put("2"+entity.getG3(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setStressRes(res);
//    }
//
//    //g2;//OXTR rs53576 同理心 TT
//    public void setEmpathy(TalnetEntity entity) {
//        entity.setG2((String) resultMap.get(entity.getNum() + "rs53576").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getG2(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setEmpathyRes(res);
//    }
//
//    //x15;//COMT rs4680 注意力 叛逆倾向 GG
////    f3;//CTNNA2 rs11902138 叛逆倾向 TT
//    public void setTreason(TalnetEntity entity) {
//        entity.setX15((String) resultMap.get(entity.getNum() + "rs4680").get(1));
//        entity.setF3((String) resultMap.get(entity.getNum() + "rs11902138").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX15(), "GG");
//        stringStringHashMap.put("2"+entity.getF3(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setTreasonRes(res);
//    }
//
//    //f1;//HM rs10034228 高度近视（600度以上）风险 TT
//    public void setHighMyopia(TalnetEntity entity) {
//        entity.setF1((String) resultMap.get(entity.getNum() + "rs10034228").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getF1(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setHighMyopiaRes(res);
//    }
//
//    //y1;//VA rs11645428 脂溶性维生素吸收风险 GG
//    public void setLip(TalnetEntity entity) {
//        entity.setY1((String) resultMap.get(entity.getNum() + "rs11645428").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getY1(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setLipRes(res);
//    }
//
//    //    y2;//MS4A3 rs2298585 水溶性维生素吸收 TT
//    public void setWater(TalnetEntity entity) {
//        entity.setY2((String) resultMap.get(entity.getNum() + "rs2298585").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getY2(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setWaterRes(res);
//    }
//
//    //x6;//SNAP25 rs363050 认知能力 棋牌能力 GG
//    public void setChess(TalnetEntity entity) {
//        entity.setX6((String) resultMap.get(entity.getNum() + "rs363050").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX6(), "GG");
//        double res = getRes(stringStringHashMap);
//        entity.setChessRes(res);
//    }
//
//    //x1;//ANKK1 rs1800497 创造力 企业家潜能 TT
//    public void setBusiness(TalnetEntity entity) {
//        entity.setX1((String) resultMap.get(entity.getNum() + "rs1800497").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX1(), "TT");
//        double res = getRes(stringStringHashMap);
//        entity.setBusinessRes(res);
//    }
//
//    //x4;//CHRM2 rs324650 逻辑思维能力 科学家潜能 TT
////    x7;//ARID1B rs12199332 逻辑思维能力 科学家潜能 GG
////    x8;//FAM43A rs789859 逻辑思维能力 科学家潜能 CC
//    public void setScientist(TalnetEntity entity) {
//        entity.setX4((String) resultMap.get(entity.getNum() + "rs324650").get(1));
//        entity.setX7((String) resultMap.get(entity.getNum() + "rs12199332").get(1));
//        entity.setX8((String) resultMap.get(entity.getNum() + "rs789859").get(1));
//        HashMap<String,String> stringStringHashMap = new HashMap<String,String>();
//        stringStringHashMap.put("1"+entity.getX4(), "TT");
//        stringStringHashMap.put("2"+entity.getX7(), "GG");
//        stringStringHashMap.put("3"+entity.getX8(), "CC");
//        double res = getRes(stringStringHashMap);
//        entity.setScientistRes(res);
//    }
//
//    public static void main(String[] args) {
//        new CreateReportAction();
//    }
//}
