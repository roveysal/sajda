package uz.pdp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Namoz {
    private String region;
    private String date;
    private String weekday;
    private Times times;
    private List<Namoz> namozList;


    @Override
    public String toString() {
        return "✨Bugungi namoz vaqtlari:" +'\n'+
                '\n'+
                "\uD83C\uDFD9Hudud: "+region+'\n'+
                "\uD83D\uDCC6Sana: "+date+'\n'+
                "\uD83D\uDCC5Hafta kuni: "+weekday+'\n'+'\n'+
                "\uD83D\uDD50Namoz vaqtlari kirishi: "+times+"\n  ";
    }


}
