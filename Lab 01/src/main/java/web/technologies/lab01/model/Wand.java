package web.technologies.lab01.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wand {

    private UUID id;

    private WandWood wood;
    private WandCore core;
    private double length;

    private String owner;

}
