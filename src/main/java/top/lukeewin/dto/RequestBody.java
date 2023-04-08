package top.lukeewin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author Luke Ewin
 * @create 2023-04-08 18:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBody {
    private String model;
    private List<Message> messages;
}
