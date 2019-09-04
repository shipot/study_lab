package com.zx.starter.controller.date;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public enum TimeEnum {

        A(1, LocalTime.of(6,0),LocalTime.of(7,0)),
        B(2, LocalTime.of(7,0),LocalTime.of(8,0)),
        C(3, LocalTime.of(8,0),LocalTime.of(9,0)),
        D(4, LocalTime.of(9,0),LocalTime.of(10,0)),
        E(5, LocalTime.of(10,0),LocalTime.of(11,0)),
        F(6, LocalTime.of(11,0),LocalTime.of(12,0)),
        G(7, LocalTime.of(12,0),LocalTime.of(13,0)),
        H(8, LocalTime.of(13,0),LocalTime.of(14,0)),
        I(9, LocalTime.of(14,0),LocalTime.of(15,0)),
       J(10, LocalTime.of(15,0),LocalTime.of(16,0)),
        K(11, LocalTime.of(16,0),LocalTime.of(17,0)),
        L(12, LocalTime.of(17,0),LocalTime.of(18,0)),
        M(13, LocalTime.of(18,0),LocalTime.of(19,0)),
        N(14, LocalTime.of(19,0),LocalTime.of(20,0)),
        O(15, LocalTime.of(20,0),LocalTime.of(21,0)),
        P(16, LocalTime.of(21,0),LocalTime.of(22,0)),
        Q(17, LocalTime.of(22,0),LocalTime.of(23,0)),
        R(18, LocalTime.of(23,0),LocalTime.of(0,0)),
        S(19, LocalTime.of(0,0),LocalTime.of(1,0)),
        T(20, LocalTime.of(1,0),LocalTime.of(2,0)),
        U(21, LocalTime.of(2,0),LocalTime.of(3,0)),
        V(22, LocalTime.of(3,0),LocalTime.of(4,0)),
        W(23, LocalTime.of(4,0),LocalTime.of(5,0)),
        X(24, LocalTime.of(5,0),LocalTime.of(6,0)),
        ;


        private Integer value;
        private LocalTime start;
        private LocalTime end;

                public static   Integer getValue(LocalTime time){
                for (TimeEnum t : TimeEnum.values()){
                        if (t.getStart().compareTo(time)<=0 && t.getEnd().compareTo(time) >0){
                                return t.value;
                        }
                }
                return null;
        }

        public static   LocalTime getTime(Integer value){
                for (TimeEnum t : TimeEnum.values()){
                        if (t.value.equals(value)){
                                return t.getStart();
                        }
                }
                return null;
        }

}
