package com.zhuzhuhe.util;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by 琦哥 on 2020/1/4.
 * 检测项目枚举类
 */
public enum CheckProgramEnum {
    AQP4_MOG_GFAP("AQP4+MOG+GFAP三项抗体检测",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗GFAP抗体IgG4"},4),
    AQP4_MOG_GFAP_DISCOUNT("AQP4+MOG+GFAP三项抗体检测优惠套餐",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗GFAP抗体IgG4"},4),
    a1("副肿瘤六项抗体检测",new String[]{"抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG"},0),
    a2("副肿瘤十四项抗体检测",new String[]{"抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗Ma1抗体IgG","抗SOX1抗体IgG","抗Tr(DNER)抗体IgG","抗Zic4抗体IgG","抗GAD65抗体IgG","抗PKCγ抗体IgG","抗Recoverin抗体IgG","抗Titin抗体IgG"},0),
    a3("副肿瘤十四项抗体检测优惠套餐",new String[]{"抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗Ma1抗体IgG","抗SOX1抗体IgG","抗Tr(DNER)抗体IgG","抗Zic4抗体IgG","抗GAD65抗体IgG","抗PKCγ抗体IgG","抗Recoverin抗体IgG","抗Titin抗体IgG"},0),
    a4("抗AMPA1抗体检测",new String[]{"抗AMPA1抗体IgG"},2),
    a5("抗AMPA2抗体检测",new String[]{"抗AMPA2抗体IgG"},2),
    a6("抗Amphiphysin抗体检测",new String[]{"抗Amphiphysin抗体IgG"},0),
    a7("抗AQP1抗体检测",new String[]{"抗AQP1抗体IgG"},2),
    a8("抗AQP4抗体检测",new String[]{"抗AQP4抗体IgG"},2),
    a9("抗CASPR1抗体检测",new String[]{"抗CASPR1抗体IgG"},2),
    a10("抗CASPR2抗体检测",new String[]{"抗CASPR2抗体IgG"},2),
    a11("抗CNTN1抗体检测",new String[]{"抗CNTN1抗体IgG4"},2),
    a12("抗CNTN2抗体检测",new String[]{"抗CNTN2抗体IgG"},2),
    a13("抗D2R抗体检测",new String[]{"抗D2R抗体IgG"},2),
    a14("抗DPPX抗体检测",new String[]{"抗DPPX抗体IgG"},2),
    a15("抗Flotillin1-2抗体检测",new String[]{"抗Flotillin1-2抗体IgG"},2),
    a16("抗GABAARa1抗体检测",new String[]{"抗GABAARa1抗体IgG"},2),
    a17("抗GABAARβ3抗体检测",new String[]{"抗GABAARβ3抗体IgG"},2),
    a18("抗GABAB抗体检测",new String[]{"抗GABAB抗体IgG"},2),
    a19("抗GAD65抗体检测",new String[]{"抗GAD65抗体IgG"},0),
    a20("抗GFAP抗体检测",new String[]{"抗GFAP抗体IgG"},2),
    a21("抗GlyRa1抗体检测",new String[]{"抗GlyRa1抗体IgG"},2),
    a22("抗GQ1b抗体检测",new String[]{"抗GQ1b抗体IgG","抗GQ1b抗体IgM"},0),
    a23("抗IgLON5抗体检测",new String[]{"抗IgLON5抗体IgG"},2),
    a24("抗LGI1抗体检测",new String[]{"抗LGI1抗体IgG"},2),
    a25("抗MAG抗体检测",new String[]{"抗MAG抗体IgG"},2),
    a26("抗MBP抗体检测",new String[]{"抗MBP抗体IgG"},2),
    a27("抗mGluR5抗体检测",new String[]{"抗mGluR5抗体IgG"},2),
    a28("抗MOG抗体检测",new String[]{"抗MOG抗体IgG"},2),
    a29("抗MuSK抗体检测",new String[]{"抗MuSK抗体IgG4"},2),
    a30("抗Neurexin-3α抗体检测",new String[]{"抗Neurexin-3α抗体IgG"},2),
    a31("抗NF155抗体检测",new String[]{"抗NF155抗体IgG4"},2),
    a32("抗NF186抗体检测",new String[]{"抗NF186抗体IgG"},2),
    a33("抗NMDAR抗体检测",new String[]{"抗NMDAR抗体IgG"},2),
    a34("抗神经细胞抗体谱6+1组合抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗DPPX抗体IgG"},0),
    a35("抗神经细胞抗体谱6+2组合抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG"},0),
    a36("抗神经细胞抗体谱6+3组合抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GAD65抗体IgG"},0),
    a37("抗神经细胞抗体谱6+6组合抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GlyRα1抗体IgG","抗GABAARα1抗体IgG","抗GABAARβ3抗体IgG","抗mGluR5抗体IgG"},0),
    a38("抗神经细胞抗体谱6+8组合抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GlyRα1抗体IgG","抗GABAARα1抗体IgG","抗GABAARβ3抗体IgG","抗mGluR5抗体IgG","抗D2R抗体IgG","抗Neurexin-3α抗体IgG"},0),
    a39("抗神经细胞抗体谱6+9组合抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GlyRα1抗体IgG","抗GABAARα1抗体IgG","抗GABAARβ3抗体IgG","抗mGluR5抗体IgG","抗D2R抗体IgG","抗Neurexin-3α抗体IgG","抗GAD65抗体IgG"},0),
    a40("抗肌炎抗体谱14项检测",new String[]{"抗SAE1抗体IgG","抗NXP2抗体IgG","抗PM-Scl100抗体IgG","抗PM-Scl75抗体IgG","抗SRP54抗体IgG","抗OJ抗体IgG","抗MDA5抗体IgG","抗Ro-52抗体IgG","抗Mi-2α抗体IgG","抗JO-1抗体IgG","抗PL-7抗体IgG","抗PL-12抗体IgG","抗EJ抗体IgG","抗Ku70抗体IgG"},0),
    a41("抗神经细胞抗体谱七项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM"},0),
    a42("抗神经细胞抗体谱七项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM"},0),
    a77("抗神经细胞抗体谱九项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM"},0),
    a43("抗神经细胞抗体谱九项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM"},0),
    a44("抗神经细胞抗体谱八项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG"},0),
    a45("抗神经细胞抗体谱八项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG"},0),
    a46("抗神经细胞抗体谱六项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG"},0),
    a47("抗神经细胞抗体谱六项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG"},0),
    a48("抗神经细胞抗体谱大套餐A抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GFAP抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM","抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗GAD65抗体IgG"},0),
    a49("抗神经细胞抗体谱大套餐B抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GFAP抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GlyRα1抗体IgG","抗GABAARα1 抗体IgG","抗GABAARβ3 抗体IgG","抗mGluR5 抗体IgG","抗D2R抗体IgG","抗Neurexin3α抗体IgG","抗GQ1b抗体IgG"," 抗GQ1b抗体IgM","抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗GAD65抗体IgG"},0),
    a50("抗神经细胞抗体谱大套餐C抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GFAP抗体IgG","抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GlyRα1抗体IgG","抗GABAARα1 抗体IgG","抗GABAARβ3 抗体IgG","抗mGluR5 抗体IgG","抗D2R抗体IgG","抗Neurexin3α抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM","抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗Ma1抗体IgG","抗SOX1抗体IgG","抗Tr(DNER)抗体IgG","抗Zic4抗体IgG","抗GAD65抗体IgG","抗PKCγ抗体IgG"},0),
    a51("抗神经细胞抗体谱十一项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM","抗DPPX抗体IgG","抗IgLON5抗体IgG"},0),
    a52("抗神经细胞抗体谱十一项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM","抗DPPX抗体IgG","抗IgLON5抗体IgG"},0),
    a53("抗神经细胞抗体谱十二项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG",},0),
    a54("抗神经细胞抗体谱十二项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG",},0),
    a55("抗神经细胞抗体谱十八项检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗Ma1抗体IgG","抗SOX1抗体IgG","抗Tr(DNER)抗体IgG","抗Zic4抗体IgG","抗GAD65抗体IgG","抗PKCγ抗体IgG"},0),
    a56("抗神经细胞抗体谱十项抗体检测",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM","抗IgLON5抗体IgG"},0),
    a57("抗神经细胞抗体谱十项抗体检测优惠套餐",new String[]{"抗NMDAR抗体IgG","抗AMPAR1抗体IgG","抗AMPAR2抗体IgG","抗LGI 1抗体IgG","抗CASPR2抗体IgG","抗GABABR抗体IgG","抗AQP4抗体IgG","抗MOG抗体IgG","抗GQ1b抗体IgG","抗GQ1b抗体IgM","抗IgLON5抗体IgG"},0),
    a58("抗神经细胞抗体谱小套餐九项抗体检测",new String[]{"抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GABAARα1抗体IgG","抗GABAARβ3抗体IgG","抗GlyRα1抗体IgG","抗mGluR5抗体IgG","抗D2R抗体IgG","抗Neurexin3α抗体IgG","抗GAD65抗体IgG"},0),
    a59("抗神经细胞抗体谱小套餐九项抗体检测优惠套餐",new String[]{"抗DPPX抗体IgG","抗IgLON5抗体IgG","抗GABAARα1抗体IgG","抗GABAARβ3抗体IgG","抗GlyRα1抗体IgG","抗mGluR5抗体IgG","抗D2R抗体IgG","抗Neurexin3α抗体IgG","抗GAD65抗体IgG"},0),
    a60("郎飞氏结相关两项抗体检测",new String[]{"抗NF155抗体IgG4","抗NF186抗体IgG"},3),
    a61("中枢神经脱髓鞘3+1项抗体检测",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗MBP抗体IgG4","抗Flotillin1/2抗体IgG"},5),
    a62("中枢神经脱髓鞘两项抗体检测",new String[]{"抗AQP4抗体IgG","抗MOG抗体IgG"},4),
    a63("小脑抗体谱七项检测",new String[]{"抗GAD65抗体IgG","抗Zic4抗体IgG","抗Tr(DNER)抗体IgG","抗CV2(CRMP5)抗体IgG","抗Homer3 抗体IgG","抗ATP1A3 抗体IgG","抗ARHGAP26抗体IgG"},0),
    a64("小脑抗体谱十六项抗体检测",new String[]{"抗Hu抗体IgG","抗Yo抗体IgG","抗Ri抗体IgG","抗CV2抗体IgG","抗Ma2抗体IgG","抗Amphiphysin抗体IgG","抗Tr(DNER)抗体IgG","抗Zic4抗体IgG","抗Ma1抗体IgG","抗GAD65抗体IgG","抗PKCγ抗体IgG","抗SOX1抗体IgG","抗Homer3抗体IgG","抗ATP1A3抗体IgG","抗ARHGAP26抗体IgG","抗ITPR1抗体IgG"},0),
    a65("神经节苷脂三项抗体检测",new String[]{"抗GQ1b抗体IgG","抗GD1b抗体IgG","抗GM1抗体IgG","抗GQ1b抗体IgM","抗GD1b抗体IgM","抗GM1抗体IgM"},0),
    a66("神经节苷脂三项抗体检测优惠套餐",new String[]{"抗GQ1b抗体IgG","抗GD1b抗体IgG","抗GM1抗体IgG","抗GQ1b抗体IgM","抗GD1b抗体IgM","抗GM1抗体IgM"},0),
    a67("神经节苷脂十二项抗体检测",new String[]{"抗sulfatides抗体IgG","抗GQ1b抗体IgG","抗GT1b抗体IgG","抗GT1a抗体IgG","抗GD3抗体IgG","抗GD2抗体IgG","抗GD1b抗体IgG","抗GD1a抗体IgG","抗GM4抗体IgG","抗GM3抗体IgG","抗GM2抗体IgG","抗GM1抗体IgG","抗sulfatides抗体IgM","抗GQ1b抗体IgM","抗GT1b抗体IgM","抗GT1a抗体IgM","抗GD3抗体IgM","抗GD2抗体IgM","抗GD1b抗体IgM","抗GD1a抗体IgM","抗GM4抗体IgM","抗GM3抗体IgM","抗GM2抗体IgM","抗GM1抗体IgM"},0),
    a68("神经节苷脂十二项抗体检测优惠套餐",new String[]{"抗sulfatides抗体IgG","抗GQ1b抗体IgG","抗GT1b抗体IgG","抗GT1a抗体IgG","抗GD3抗体IgG","抗GD2抗体IgG","抗GD1b抗体IgG","抗GD1a抗体IgG","抗GM4抗体IgG","抗GM3抗体IgG","抗GM2抗体IgG","抗GM1抗体IgG","抗sulfatides抗体IgM","抗GQ1b抗体IgM","抗GT1b抗体IgM","抗GT1a抗体IgM","抗GD3抗体IgM","抗GD2抗体IgM","抗GD1b抗体IgM","抗GD1a抗体IgM","抗GM4抗体IgM","抗GM3抗体IgM","抗GM2抗体IgM","抗GM1抗体IgM"},0),
    a69("郎飞氏结相关三项抗体检测",new String[]{"抗NF155抗体IgG4","抗NF186抗体IgG","抗CNTN1抗体IgG4"},4),
    a70("郎飞氏结相关五项抗体检测",new String[]{"抗NF155抗体IgG4","抗NF186抗体IgG","抗CNTN1抗体IgG4","抗CNTN2抗体IgG","抗CASPR1抗体IgG"},6),
    a71("中枢神经脱髓鞘三项抗体检测",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗MBP抗体IgG4"},4),
    a72("中枢神经脱髓鞘五项抗体检测",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗MBP抗体IgG4","抗GFAP抗体IgG","抗AQP1抗体IgG"},6),
    a73("中枢神经脱髓鞘六项抗体检测",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗MBP抗体IgG4","抗GFAP抗体IgG","抗AQP1抗体IgG","抗Flotillin1/2抗体IgG"},7),
    a74("中枢神经脱髓鞘四项抗体检测",new String[]{"抗AQP4抗体IgG4","抗MOG抗体IgG","抗MBP抗体IgG4","抗GFAP抗体IgG"},5),
    a75("周围神经病17项抗体检测",new String[]{"抗GM1抗体IgG","抗GM2抗体IgG","抗GM3抗体IgG","抗GM4抗体IgG","抗GD1a抗体IgG","抗GD1b抗体IgG","抗GD2抗体IgG","抗GD3抗体IgG","抗GT1a抗体IgG","抗GT1b抗体IgG","抗GQ1b抗体IgG","抗sulfatide抗体IgG","抗GM1抗体IgM","抗GM2抗体IgM","抗GM3抗体IgM","抗GM4抗体IgM","抗GD1a抗IgM","抗GD1b抗体IgM","抗GD2抗体IgM","抗GD3抗体IgM","抗GT1a抗体IgM","抗GT1b抗体IgM","抗GQ1b抗体IgM","抗sulfatide抗体IgM","抗NF155抗体IgG4","抗NF186抗体IgG","抗CNTN1抗体IgG4","抗CNTN2抗体IgG","抗CASPR1抗体IgG"},0),
    a76("周围神经病17项抗体检测优惠套餐",new String[]{"抗GM1抗体IgG","抗GM2抗体IgG","抗GM3抗体IgG","抗GM4抗体IgG","抗GD1a抗体IgG","抗GD1b抗体IgG","抗GD2抗体IgG","抗GD3抗体IgG","抗GT1a抗体IgG","抗GT1b抗体IgG","抗GQ1b抗体IgG","抗sulfatide抗体IgG","抗GM1抗体IgM","抗GM2抗体IgM","抗GM3抗体IgM","抗GM4抗体IgM","抗GD1a抗IgM","抗GD1b抗体IgM","抗GD2抗体IgM","抗GD3抗体IgM","抗GT1a抗体IgM","抗GT1b抗体IgM","抗GQ1b抗体IgM","抗sulfatide抗体IgM","抗NF155抗体IgG4","抗NF186抗体IgG","抗CNTN1抗体IgG4","抗CNTN2抗体IgG","抗CASPR1抗体IgG"},0);

    private String checkProgram;//检测项目
    private String[] programName;//项目名称
    private int picNum;//项目所包含图片数目，对照也算一个

    public static CheckProgramEnum getCheckProgramEnum(String checkProgram){
        if(StringUtils.isBlank(checkProgram)){
            return null;
        }
        for (CheckProgramEnum checkProgramEnum : CheckProgramEnum.values()) {
            if(checkProgramEnum.getCheckProgram().equals(checkProgram)){
                return checkProgramEnum;
            }
        }
        return null;

    }

    CheckProgramEnum(String checkProgram, String[] programName, int picNum) {
        this.checkProgram = checkProgram;
        this.programName = programName;
        this.picNum = picNum;
    }

    public String getCheckProgram() {
        return checkProgram;
    }

    public String[] getProgramName() {
        return programName;
    }

    public int getPicNum() {
        return picNum;
    }


}
