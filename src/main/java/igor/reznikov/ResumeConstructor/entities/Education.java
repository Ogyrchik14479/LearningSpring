package igor.reznikov.ResumeConstructor.entities;

import igor.reznikov.ResumeConstructor.enums.FormOfEducationEnum;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Education extends AbstractPersistable<Long> {

    String institution;

    String faculty;

    String specialization;

    @Enumerated(EnumType.STRING)
    FormOfEducationEnum formOfEducationEnum;

    Integer yearOfGraduation;
}