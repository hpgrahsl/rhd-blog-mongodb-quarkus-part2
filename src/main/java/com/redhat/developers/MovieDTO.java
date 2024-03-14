package com.redhat.developers;

import java.time.Year;
import java.util.List;

public record MovieDTO(
    String id,
    String title,
    List<String> genres,
    Integer runningTime,
    Boolean released,
    Year yearReleased
) {};

