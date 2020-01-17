package com.zhuzhuhe.start;

import com.zhuzhuhe.entity.ReportEntity;
import com.zhuzhuhe.service.CreateReportServiceImpl;
import com.zhuzhuhe.util.ExcelUtils;
import org.apache.poi.ss.usermodel.PictureData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by 琦哥 on 2020/1/5.
 * 启动程序入口
 */
public class StartAction extends JFrame implements ActionListener {
    JButton jbResult = new JButton("导入检测结果并生成报告");

    public StartAction() {
        jbResult.setActionCommand("openResult");
        jbResult.setBackground(Color.CYAN);//设置按钮颜色
        jbResult.setSize(20, 20);
        //初始化一个文字区域

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(jbResult);//建立容器使用边界布局
        //
        jbResult.addActionListener(this);
        this.setTitle("报告生成工具");
        this.setSize(600, 400);
        this.setLocation(200, 200);
        //显示窗口true
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("openResult")) {
            JFileChooser jf = new JFileChooser();
            jf.showOpenDialog(this);//显示打开的文件对话框
            File f = jf.getSelectedFile();//使用文件类获取选择器选择的文件
            String path = f.getAbsolutePath();//返回路径名
            ExcelUtils readExcelUtils = new ExcelUtils(path);
            CreateReportServiceImpl createReportService = new CreateReportServiceImpl();
            try {
                Map<Integer, Map<Integer, Object>> content = readExcelUtils.readExcelContent();
                List<? extends PictureData> allPictures = readExcelUtils.getAllPictures();
                List<ReportEntity> reportEntities = createReportService.excel2Entity(content, allPictures);
                for (ReportEntity reportEntity : reportEntities) {
                    createReportService.createReport(reportEntity);
                }
                JOptionPane.showMessageDialog(this, "成功生成所有报告", "标题", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "生成所有报告失败", "标题", JOptionPane.WARNING_MESSAGE);
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\琦哥\\Desktop\\2.xlsx");
//        Map<Integer, Map<Integer, Object>> content = excelUtils.readExcelContent();
//        List<? extends PictureData> allPictures = excelUtils.getAllPictures();
//        CreateReportServiceImpl createReportService = new CreateReportServiceImpl();
//        List<ReportEntity> reportEntities = createReportService.excel2Entity(content, allPictures);
//        for (ReportEntity reportEntity : reportEntities) {
//            createReportService.createReport(reportEntity);
//        }
        new StartAction();
    }
}
