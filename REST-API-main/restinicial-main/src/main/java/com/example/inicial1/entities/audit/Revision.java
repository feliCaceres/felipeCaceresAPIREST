package com.example.inicial1.entities.audit;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import com.example.inicial1.config.CustomRevisionListener;

import java.io.Serializable;
import java.util.Date;

@Entity
@RevisionEntity(CustomRevisionListener.class)
@Data
@EqualsAndHashCode
@Table(name = "REVISION_INFO")
public class Revision implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "revision_seq")
    @SequenceGenerator(
            name="revision_seq",
            sequenceName="rbac.seq_revision_id"
    )
    @RevisionNumber
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;

}
