package uz.pdp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Times {
    private String tong_saharlik;
    private String quyosh;
    private String peshin;
    private String asr;
    private String shom_iftor;
    private String hufton;

    @Override
    public String toString() {
        return '\n'+
                "⏰ Bomdod (Fajr): "+tong_saharlik+'\n'+
                "\uD83C\uDF04 Tong(Suhoor): "+quyosh+'\n'+
                "\uD83D\uDD70\uFE0F Peshin (Dhuhr): "+peshin+'\n'+
                "\uD83C\uDF07 Asr (Asr): "+asr+'\n'+
                "\uD83C\uDF19 Shom (Maghrib): "+shom_iftor+'\n'+
                "\uD83C\uDF0C Xufton (Isha): "+hufton;
    }
}
