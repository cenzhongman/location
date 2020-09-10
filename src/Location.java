package org.example.authorization.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cenzhongman
 * @date 2020/9/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private int code;
    private String name;
    private int level;
    private List<Location> locations;
}
