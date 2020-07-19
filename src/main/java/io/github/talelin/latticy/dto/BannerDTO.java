package io.github.talelin.latticy.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class BannerDTO {
    @Length(min = 2,max = 20)
    private String name;
    @Length(min = 2,max = 256)
    private String description;
    @Length(min = 2,max = 20)
    private String title;
    @Length(min = 2,max = 256)
    private String img;
}
