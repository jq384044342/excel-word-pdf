//package www.qige.word;
//
//import com.deepoove.poi.XWPFTemplate;
//import com.deepoove.poi.data.PictureRenderData;
//import www.qige.entity.TalnetEntity;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by jiaqi on 2018/10/17 0017.
// */
//public class CreateWordReportImpl {
//
//    public void createReport(TalnetEntity entity) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", entity.getName());
//        map.put("sex", entity.getSex());
//        map.put("num", entity.getNum());
//        map.put("age", entity.getAge());
//        map.put("fileName", entity.getFileName());
//        map.put("memoryResSug", entity.getMemoryResSug());
////        String rootpath = CreateWordReportImpl.class.getClassLoader().getResource(entity.getMemoryResPic()).getPath();
//        String rootpath = "template\\" ;
//        map.put("memoryResPic", new PictureRenderData(getWidth(entity.getMemoryRes()),40,rootpath+entity.getMemoryResPic()));
//        map.put("attentionResSug", entity.getAttentionResSug());
//        map.put("attentionResPic", new PictureRenderData(getWidth(entity.getAttentionRes()),40,rootpath+entity.getAttentionResPic()));
//        map.put("creativityResSug", entity.getCreativityResSug());
//        map.put("creativityResPic", new PictureRenderData(getWidth(entity.getCreativityRes()),40,rootpath+entity.getCreativityResPic()));
//        map.put("logicalResSug", entity.getLogicalResSug());
//        map.put("logicalResPic", new PictureRenderData(getWidth(entity.getLogicalRes()),40,rootpath+entity.getLogicalResPic()));
//        map.put("langResSug", entity.getLangResSug());
//        map.put("langResPic", new PictureRenderData(getWidth(entity.getLangRes()),40,rootpath+entity.getLangResPic()));
//        map.put("learnResSug", entity.getLearnResSug());
//        map.put("learnResPic", new PictureRenderData(getWidth(entity.getLearnRes()),40,rootpath+entity.getLearnResPic()));
//        map.put("perceResSug", entity.getPerceResSug());
//        map.put("perceResPic", new PictureRenderData(getWidth(entity.getPerceRes()),40,rootpath+entity.getPerceResPic()));
//        map.put("paintResSug", entity.getPaintResSug());
//        map.put("paintResPic", new PictureRenderData(getWidth(entity.getPaintRes()),40,rootpath+entity.getPaintResPic()));
//        map.put("musicResSug", entity.getMusicResSug());
//        map.put("musicResPic", new PictureRenderData(getWidth(entity.getMusicRes()),40,rootpath+entity.getMusicResPic()));
//        map.put("danceResSug", entity.getDanceResSug());
//        map.put("danceResPic", new PictureRenderData(getWidth(entity.getDanceRes()),40,rootpath+entity.getDanceResPic()));
//        map.put("enduranceResSug", entity.getEnduranceResSug());
//        map.put("enduranceResPic", new PictureRenderData(getWidth(entity.getEnduranceRes()),40,rootpath+entity.getEnduranceResPic()));
//        map.put("speedResSug", entity.getSpeedResSug());
//        map.put("speedResPic", new PictureRenderData(getWidth(entity.getSpeedRes()),40,rootpath+entity.getSpeedResPic()));
//        map.put("leadResSug", entity.getLeadResSug());
//        map.put("leadResPic", new PictureRenderData(getWidth(entity.getLeadRes()),40,rootpath+entity.getLeadResPic()));
//        map.put("stressResSug", entity.getStressResSug());
//        map.put("stressResPic", new PictureRenderData(getWidth(entity.getStressRes()),40,rootpath+entity.getStressResPic()));
//        map.put("empathyResSug", entity.getEmpathyResSug());
//        map.put("empathyResPic", new PictureRenderData(getWidth(entity.getEmpathyRes()),40,rootpath+entity.getEmpathyResPic()));
//        map.put("treasonResSug", entity.getTreasonResSug());
//        map.put("treasonResPic", entity.getTreasonResPic());
//        map.put("highMyopiaResSug", entity.getHighMyopiaResSug());
//        map.put("highMyopiaResPic", entity.getHighMyopiaResPic());
//        map.put("lipResSug", entity.getLipResSug());
//        map.put("lipResPic", new PictureRenderData(getWidth(entity.getLipRes()),40,rootpath+entity.getLipResPic()));
//        map.put("waterResSug", entity.getWaterResSug());
//        map.put("waterResPic", new PictureRenderData(getWidth(entity.getWaterRes()),40,rootpath+entity.getWaterResPic()));
//        map.put("chessResSug", entity.getChessResSug());
//        map.put("chessResPic", new PictureRenderData(getWidth(entity.getChessRes()),40,rootpath+entity.getChessResPic()));
//        map.put("businessResSug", entity.getBusinessResSug());
//        map.put("businessResPic", new PictureRenderData(getWidth(entity.getBusinessRes()),40,rootpath+entity.getBusinessResPic()));
//        map.put("scientistResSug", entity.getScientistResSug());
//        map.put("scientistResPic", new PictureRenderData(getWidth(entity.getScientistRes()),40,rootpath+entity.getScientistResPic()));
//        map.put("X2", entity.getX2());
//        map.put("X3", entity.getX3());
//        map.put("X15", entity.getX15());
//        map.put("X16", entity.getX16());
//        map.put("X1", entity.getX1());
//        map.put("X4", entity.getX4());
//        map.put("X7", entity.getX7());
//        map.put("X8", entity.getX8());
//        map.put("X10", entity.getX10());
//        map.put("X11", entity.getX11());
//        map.put("X12", entity.getX12());
//        map.put("X13", entity.getX13());
//        map.put("X14", entity.getX14());
//        map.put("X9", entity.getX9());
//        map.put("X5", entity.getX5());
//        map.put("X6", entity.getX6());
//        map.put("C1", entity.getC1());
//        map.put("C2", entity.getC2());
//        map.put("C4", entity.getC4());
//        map.put("C3", entity.getC3());
//        map.put("L1", entity.getL1());
//        map.put("G1", entity.getG1());
//        map.put("G3", entity.getG3());
//        map.put("G2", entity.getG2());
//        map.put("F3", entity.getF3());
//        map.put("F1", entity.getF1());
//        map.put("Y1", entity.getY1());
//        map.put("Y2", entity.getY2());
//        String template1= "template\\talanet.docx";
////        if ("男".equals((String) map.get("sex"))) {
////            template1 = CreateWordReportImpl.class.getClassLoader().getResource("talanet.docx").getPath();
//////            template1 = "template\\talanet.doc";
////        } else if ("女".equals((String) map.get("sex"))) {
////            template1 = CreateWordReportImpl.class.getClassLoader().getResource("talanet.docx").getPath();
//////            template1 = "template\\talanet.doc";
////        } else {
////            return;
////        }
//
//        XWPFTemplate template = XWPFTemplate.compile(template1).render(map);
//        try {
//            FileOutputStream out = new FileOutputStream("report\\" + entity.getNum() + entity.getName() + ".docx");
//            template.write(out);
//            out.flush();
//            out.close();
//            template.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private int getWidth(double res) {
//        if(res == 1){
//            return 84;
//        }else if(res>1&&res<=2){
//            return 125;
//        }else if(res>2){
//            return 171;
//        }
//        return 100;
//    }
//}
//
