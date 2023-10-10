package web.technologies.lab01.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.technologies.lab01.model.WandCore;
import web.technologies.lab01.model.WandWood;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class WandEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private WandWood wood;
    private WandCore core;
    private double length;

    @OneToOne(mappedBy = "wand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WizardEntry wizard;

}
