package sample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * If everything works right this class was
 * created by konraifen88 on 27.11.2016.
 * If it doesn't work I don't know who the hell wrote it.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReverseMessage {

    @NonNull
    private String message;
}
