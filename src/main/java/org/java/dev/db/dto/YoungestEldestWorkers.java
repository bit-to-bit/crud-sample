package org.java.dev.db.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class YoungestEldestWorkers {
    private String type;
    private String name;
    private String birthday;
}
