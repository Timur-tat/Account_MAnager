package com.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class JenericEx {
    public static void main(String[] args) {
        Accaunt<Integer, Long> account = new Accaunt();
account.setId(12);
account.setName(1L);
//String x=account.getId();
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Accaunt<T, K>{
    private T id;
    private K name;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Accaunt2{
    private long id;
}
