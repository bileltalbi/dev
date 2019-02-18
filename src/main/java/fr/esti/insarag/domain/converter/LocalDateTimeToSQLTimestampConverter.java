package fr.esti.insarag.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * JPA 2.1 was released before Java 8 so {@link LocalDateTime} cannot be mapped automatically we
 * need to define a custom converter
 *
 * @author msalem
 */
@Converter
public class LocalDateTimeToSQLTimestampConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return Objects.isNull(attribute) ? null : Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return Objects.isNull(dbData) ? null : dbData.toLocalDateTime();
    }

}