package com.mln.jacksonannotations.jsonserializer;

import lombok.Getter;
import lombok.Setter;

public class Devices {


    @Getter
    @Setter
    private String deviceType;

    @Getter
    @Setter
    private String deviceModelNo;

    @Getter
    @Setter
    private String deviceName;


}
