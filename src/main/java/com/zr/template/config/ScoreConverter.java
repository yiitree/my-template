package com.zr.template.config;


import org.dozer.DozerConverter;

public class ScoreConverter extends DozerConverter<Integer, ScoreEnum> {

    public ScoreConverter() {
        super(Integer.class, ScoreEnum.class);
    }

    @Override
    public ScoreEnum convertTo(Integer score, ScoreEnum scoreEnum) {
        if (60 <= score && score < 80){
            return ScoreEnum.C;
        }else if (80 <= score && score < 90){
            return ScoreEnum.B;
        }else if (90 <= score){
            return ScoreEnum.A;
        }else {
            return ScoreEnum.D;
        }
    }

    @Override
    public Integer convertFrom(ScoreEnum scoreEnum, Integer integer) {
        return null;
    }
}
