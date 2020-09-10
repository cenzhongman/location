package org.example.authorization.server.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.authorization.server.domain.Location;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author cenzhongman
 * @date 2020/9/10
 */
public class LocationUtils {
    private static final String[] specialAdministrativeRegion = {
            "110000",
            "120000",
            "310000",
            "500000",
            "810000",
            "820000"};

    public static void load(InputStream is) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map user = mapper.readValue(is, Map.class);
        Location china = new Location(100000, "中国", 0, new ArrayList<>());
        user.forEach((k, v) -> {
            if (k.toString().endsWith("0000")) {
                china.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(), 1, new ArrayList<>()));
            }
        });

        for (Location p : china.getLocations()) {
            user.forEach((k, v) -> {
                // 正常省
                if (
                        k.toString().startsWith(String.valueOf(p.getCode()).substring(0, 2)) &&
                                k.toString().endsWith("00") &&
                                !k.toString().equals(String.valueOf(p.getCode()))
                ) {
                    p.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(), 2, new ArrayList<>()));
                }
                // tree-1
//                if (
//                        k.toString().startsWith(String.valueOf(p.getCode()).substring(0, 2)) &&
//                                Arrays.asList(specialAdministrativeRegion).contains(String.valueOf(p.getCode())) &&
//                                "01".equals(k.toString().substring(2, 4)) &&
//                                !k.toString().equals(String.valueOf(p.getCode()))
//                ) {
//                    p.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(),3, new ArrayList<>()));
//                }

                //tree-2
                if (
                        Arrays.asList(specialAdministrativeRegion).contains(String.valueOf(p.getCode())) &&
                                k.toString().equals(String.valueOf(p.getCode()))
                ) {
                    p.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(), 2, new ArrayList<>()));
                }
            });
//            System.out.println(mapper.writeValueAsString(p));
        }

        for (Location p : china.getLocations()) {
            for (Location c : p.getLocations()) {
                user.forEach((k, v) -> {
                    // tree-1
//                    if (!Arrays.asList(specialAdministrativeRegion).contains(String.valueOf(p.getCode())) &&
//                            k.toString().startsWith(String.valueOf(c.getCode()).substring(0, 4)) &&
//                            !k.toString().equals(String.valueOf(c.getCode()))
//                    ) {
//                        c.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(), 3, new ArrayList<>()));
//                    }

                   // tree-2
                    if (k.toString().startsWith(String.valueOf(c.getCode()).substring(0, 4)) &&
                            !k.toString().equals(String.valueOf(c.getCode()))
                    ) {
                        c.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(), 3, new ArrayList<>()));
                    }

                    if (Arrays.asList(specialAdministrativeRegion).contains(String.valueOf(p.getCode())) &&
                            k.toString().startsWith(String.valueOf(c.getCode()).substring(0, 2)) &&
                            !k.toString().equals(String.valueOf(c.getCode()))
                    ) {
                        c.getLocations().add(new Location(Integer.parseInt((String) k), v.toString(), 3, new ArrayList<>()));
                    }
                });
//                System.out.println(mapper.writeValueAsString(c));
            }
        }

        System.out.println(mapper.writeValueAsString(china));
    }
}
