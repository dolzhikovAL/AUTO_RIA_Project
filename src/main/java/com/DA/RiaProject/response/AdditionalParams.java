package com.DA.RiaProject.response;

import com.DA.RiaProject.entities.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalParams extends BaseEntity {
    //    language id
    @JsonProperty("lang_id")
    private int langId;
    //    page number
    private int page;
    private String section;
}
