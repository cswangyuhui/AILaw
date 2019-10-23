package com.law.kg.comm;

import org.springframework.stereotype.Component;

public enum KnowledgeType {
    marriage_family("婚姻家庭", 0,3), criminal_defense("刑事辩护", 1,3), traffic_accident("交通事故", 2,3), work_injuries("劳动工伤", 3,3),
    house_disputes("房产纠纷", 4,3), credit_right("债权债务", 5,3), contract_affairs("合同事务", 6,3), medical_disputes("医疗纠纷", 7,3),
    company_operation("公司经营", 8,3), intellectual_property("知识产权", 9,3), compensation_damages("损害赔偿", 10,3), construction_disputes("建设工程纠纷", 11,3),
    financial_insurance("金融保险", 12,3), litigation_arbitration("诉讼仲裁", 13,3), land_affairs("征地拆迁", 14,3), foreign_expertise("涉外专长", 15,3),
    internet_disputes("互联网纠纷", 16,3), tax_disputes("税务类纠纷", 17,3);
    // 成员变量
    private String name;
    private int index;
    private int count;
    // 构造方法
    private KnowledgeType(String name, int index, int count) {
        this.name = name;
        this.index = index;
        this.count = count;
    }

    // 普通方法
    public static String getName(int index) {
        for (KnowledgeType c : KnowledgeType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }

        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static Integer count() {
        return KnowledgeType.values().length;
    }
}
