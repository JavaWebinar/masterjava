package ru.javaops.web;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.javaops.masterjava.ExceptionType;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class FaultInfo {
    private @NonNull ExceptionType type;

    @Override
    public String toString() {
        return type.toString();
    }
}
