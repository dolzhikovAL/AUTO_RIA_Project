package com.DA.RiaProject.entities.search.request;

import com.DA.RiaProject.entities.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "search_history_drive_type_id")
public class DriveTypeId extends BaseEntity {
    private Integer driveTypeId;

    public DriveTypeId() {
    }

    @Column(name = "drivetype_id")
    public Integer getDriveTypeId() {
        return driveTypeId;
    }

    public void setDriveTypeId(Integer driveTypeId) {
        this.driveTypeId = driveTypeId;
    }
}