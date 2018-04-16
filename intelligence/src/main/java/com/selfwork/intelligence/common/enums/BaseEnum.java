package com.selfwork.intelligence.common.enums;

public interface BaseEnum<E extends Enum<?>, T> {
    T getValue();
    String getDisplayName();
}