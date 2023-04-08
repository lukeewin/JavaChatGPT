package top.lukeewin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Luke Ewin
 * @create 2023-04-08 19:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody {
    private List<Choices> choices;
}
