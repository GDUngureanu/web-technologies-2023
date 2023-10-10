package web.technologies.lab01.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.technologies.lab01.model.WizardBloodStatus;
import web.technologies.lab01.model.WizardHouse;
import web.technologies.lab01.model.WizardRole;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class WizardEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Integer age;
    private WizardBloodStatus bloodStatus;
    private WizardHouse house;
    private WizardRole role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wand_id")
    private WandEntry wand;

}
