package com.irene.music.recordCompany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recordCompany")
@Getter
@Setter
public class RecordCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_company_id")
    private int record_company_id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "email")
    private String email;

    public RecordCompany(int record_company_id, String name, String location, String email) {
        this.record_company_id = record_company_id;
        this.name = name;
        this.location = location;
        this.email = email;
    }

    public RecordCompany() {
    }
}
