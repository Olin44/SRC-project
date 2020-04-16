package pl.project;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Text {
    boolean isTranslated = false;
    String textToTranslate;
    String textTranslated;
}
