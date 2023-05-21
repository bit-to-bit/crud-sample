package org.java.dev.db.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WorkerByLevel {
    private long id;
    private String level;
    private String name;
    private String birthday;
    private Integer salary;

}
