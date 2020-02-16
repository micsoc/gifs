package pl.akademiakodu.gifs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gif {
    private String name;
    private String username;
    private Boolean favorite;
    private  int categoryId;
}
