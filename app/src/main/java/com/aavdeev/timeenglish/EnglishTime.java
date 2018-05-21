package com.aavdeev.timeenglish;

public class EnglishTime {

    private String name;
    private String description;

    public static final EnglishTime[] timeList = {
            new EnglishTime("Past simple","Past Simple (Past Indefinite) в английском языке — прошедшее время, претерит (лат. praeteritum) — одна из модальностей грамматической категории времени, форма финитного глагола, используемая для описания ситуации, имевшей место до момента речи или до момента, описываемого в речи"),
            new EnglishTime("Present Simple","Present Simple – простое настоящее время в английском языке. Оно выражает действие, которое происходит в настоящем времени или регулярно. Также оно используется для выражения действия без указания определенного времени: I work at home."),
            new EnglishTime("Future simple","Future simple(Future indefinite) — время в грамматике английского языка, указывающее на действия, которые произойдут после настоящего времени.")

    };

    public EnglishTime(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
