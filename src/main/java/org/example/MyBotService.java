package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

public class MyBotService {
    // Menyu yaratish va qaytarish
    public SendMessage menu(Long chatId) {
        // Inline tugmalarni sozlash
        ReplyKeyboardMarkup reply = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        // 1-row: Math and English tugmalari
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("📘 Math"));
        row1.add(new KeyboardButton("📗 English"));

        // 2-row: Grammar va SAT Practice tugmalari
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("📚 Vocabulary"));
        row2.add(new KeyboardButton("\uD83D\uDD17 Online Practice Platforms"));

        // 3-row: Useful Links va Desmos Solution tugmalari
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83D\uDCD4  Old Real Exams"));

        KeyboardButton button = new KeyboardButton();
        button.setText("🧮 Desmos");
        WebAppInfo webAppInfo = new WebAppInfo("https://www.desmos.com/testing/cb-sat-ap/graphing");
        button.setWebApp(webAppInfo);
        row3.add(button);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("\uD83D\uDCCC Test Centers"));
        row4.add(new KeyboardButton("\uD83D\uDCDD Register for SAT"));

        KeyboardRow row5 = new KeyboardRow();
        row5.add(new KeyboardButton("\uD83D\uDCAC Contact Admin"));

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);

        reply.setKeyboard(rowList);
        reply.setResizeKeyboard(true);

        String welcomeText = """
                👋 *Assalomu alaykum! Xush kelibsiz!*
                
                Siz bu yerda SAT imtihoni uchun kerakli materiallarni topishingiz mumkin:
                - Matematika (Algebra, Geometriya)
                - Ingliz tili (Reading, Writing, Grammar)
                - Desmos bilan yechimlar
                - SAT Practice va havolalar
                
                Iltimos, kerakli bo‘limni tanlang 👇
                """;

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(welcomeText);
        sendMessage.setParseMode("Markdown");
        sendMessage.setReplyMarkup(reply);

        return sendMessage;
    }

    public SendMessage sendLocation(Long chatId) {
        ReplyKeyboardMarkup reply = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("\uD83D\uDCCD Cambridge International College"));
        row1.add(new KeyboardButton("\uD83D\uDCCD President School of Tashkent"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("\uD83D\uDCCD Sodiq school"));
        row2.add(new KeyboardButton("\uD83D\uDCCD Tashkent International School"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83D\uDCCD Stars International University"));
        row3.add(new KeyboardButton("\uD83D\uDCCD New Uzbekistan University"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("\uD83D\uDCCD Target International School"));
        row4.add(new KeyboardButton("\uD83D\uDCCC Others"));

        KeyboardRow row5 = new KeyboardRow();
        row5.add(new KeyboardButton("⬅️ Menu"));

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);

        reply.setKeyboard(rowList);
        reply.setResizeKeyboard(true);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("SAT locations");
        sendMessage.setParseMode("Markdown");
        sendMessage.setReplyMarkup(reply);
        return sendMessage;
    }

    public SendMessage otherLocation(Long chatId) {
        ReplyKeyboardMarkup reply = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Andijan"));
        row1.add(new KeyboardButton("\uD83D\uDCCD President School of Djizzakh"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Khiva"));
        row2.add(new KeyboardButton("\uD83D\uDCCD Innovative Center(Samarqand)"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Bukhara"));
        row3.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Fergana"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Navoiy"));
        row4.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Nukus"));

        KeyboardRow row5 = new KeyboardRow();
        row5.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Nurafshon"));
        row5.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Termez"));

        KeyboardRow row6 = new KeyboardRow();
        row6.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Gulistan"));
        row6.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Karshi"));

        KeyboardRow row7 = new KeyboardRow();
        row7.add(new KeyboardButton("\uD83D\uDCCD Presidential School of Namangan"));
        row7.add(new KeyboardButton("⬅️ Back"));

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);
        rowList.add(row5);
        rowList.add(row6);
        rowList.add(row7);

        reply.setKeyboard(rowList);
        reply.setResizeKeyboard(true);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Other registration locations");
        sendMessage.setParseMode("Markdown");
        sendMessage.setReplyMarkup(reply);
        return sendMessage;
    }

    public SendMessage menuForExams(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Real exams in 2024");
        sendMessage.setChatId(chatId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();


        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("SAT INT 03.2024");
        button.setCallbackData("03.2024");
        row.add(button);

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("SAT INT 05.2024");
        button1.setCallbackData("05.2024");
        row.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("SAT INT 06.2024");
        button2.setCallbackData("06.2024");
        row1.add(button2);

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("SAT INT 08.2024");
        button3.setCallbackData("08.2024");
        row1.add(button3);

        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("SAT INT 10.2024");
        button4.setCallbackData("10.2024");
        row2.add(button4);

        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("SAT INT 11.2024");
        button5.setCallbackData("11.2024");
        row2.add(button5);

        rows.add(row);
        rows.add(row1);
        rows.add(row2);

        inlineKeyboardMarkup.setKeyboard(rows);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }


    public SendMessage sendLocMessage(Long chatId, String location) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        switch (location) {
            case "cambridge" -> sendMessage.setText("Shayhontohur District, Tashkent, Uzbekistan");
            case "president tashkent" -> sendMessage.setText("M.Ulug'bek tumani,Tashkent, Uzbekistan");
            case "sodiq" -> sendMessage.setText("3 Kumarik street, Tashkent, UZBEKISTAN\n" +
                    "Acad Lyceum Of Tashkent St Univ Of E Mahmudjon Gofurov Street 183");
            case "inter tashkent" -> sendMessage.setText("38 Sarikulskaya street Tashkent, Uzbekistan");
            case "stars" -> sendMessage.setText("2, Kutb street,Tashkent, Uzbekistan");
            case "newUzb" -> sendMessage.setText("Movarounnahr street, Tashkent, Uzbekistan");
            case "target" -> sendMessage.setText("Almazor district, Chustiy MFY, Tashkent, Uzbekistan");
            case "andijan" -> sendMessage.setText("Alisher Novoyi Shox Street, Andijon, Uzbekistan");
            case "djizzakh" -> sendMessage.setText("Istiklol 13 Sayiljoyi Mahallasi, Jizzakh, Uzbekistan");
            case "khiva" -> sendMessage.setText("Khorezm region, Khiva, Khorezm Uzbekistan");
            case "innovative" -> sendMessage.setText("Gagarin St, Samarkand Uzbekistan");
            case "bukhara" -> sendMessage.setText("1, Mukhammad Ikbol Street, Bukhara, Uzbekistan");
            case "fergana" -> sendMessage.setText("Qashqar 1, Fergana, Fergana Uzbekistan");
            case "navoiy" -> sendMessage.setText("34 B Navoi Street, Navoi, Uzbekistan");
            case "nukus" -> sendMessage.setText("1A Olmozor Street, Republic Of Karakalpakstan Uzbekistan");
            case "nurafshon" ->
                    sendMessage.setText("Yangiobod 36 Tashkent Region, Nurafshon City, Tashkent Region Uzbekistan");
            case "termez" -> sendMessage.setText("at-Termiziy street, Surkhandarya region Uzbekistan");
            case "gulistan" -> sendMessage.setText("260A Navoiy Avenue, Gulistan, Sirdaryo Uzbekistan");
            case "karshi" -> sendMessage.setText("Mustaqillik street, Qarshi, Qashqadaryo, UZBEKISTAN");
            case "namangan" -> sendMessage.setText("Islom Karimov St, 1, Namangan, Davlatobod Uzbekistan");
        }
        return sendMessage;
    }

    public SendLocation sendExactLocation(Long chatId, String location) {
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);

        switch (location) {
            case "cambridge" -> {
                sendLocation.setLatitude(41.322852);
                sendLocation.setLongitude(69.248844);
            }
            case "president tashkent" -> {
                sendLocation.setLatitude(41.337894);
                sendLocation.setLongitude(69.342085);
            }
            case "sodiq" -> {
                sendLocation.setLatitude(41.2483278);
                sendLocation.setLongitude(69.2042616);
            }
            case "inter tashkent" -> {
                sendLocation.setLatitude(41.271086);
                sendLocation.setLongitude(69.295055);
            }
            case "stars" -> {
                sendLocation.setLatitude(41.323925);
                sendLocation.setLongitude(69.315625);
            }
            case "newUzb" -> {
                sendLocation.setLatitude(41.316058);
                sendLocation.setLongitude(69.295500);
            }
            case "target" -> {
                sendLocation.setLatitude(41.330671);
                sendLocation.setLongitude(69.2233206);
            }
            case "andijan" -> {
                sendLocation.setLatitude(40.775697);
                sendLocation.setLongitude(72.357471);
            }
            case "djizzakh" -> {
                sendLocation.setLatitude(40.136868);
                sendLocation.setLongitude(67.820922);
            }
            case "khiva" -> {
                sendLocation.setLatitude(41.379908);
                sendLocation.setLongitude(60.369412);
            }
            case "innovative" -> {
                sendLocation.setLatitude(39.658118);
                sendLocation.setLongitude(66.936662);
            }
            case "bukhara" -> {
                sendLocation.setLatitude(39.758912);
                sendLocation.setLongitude(64.422908);
            }
            case "fergana" -> {
                sendLocation.setLatitude(40.378115);
                sendLocation.setLongitude(71.790485);
            }
            case "navoiy" -> {
                sendLocation.setLatitude(40.111587);
                sendLocation.setLongitude(65.363939);
            }
            case "nukus" -> {
                sendLocation.setLatitude(42.461863);
                sendLocation.setLongitude(59.616631);
            }
            case "nurafshon" -> {
                sendLocation.setLatitude(41.027813);
                sendLocation.setLongitude(69.345662);
            }
            case "termez" -> {
                sendLocation.setLatitude(37.244435);
                sendLocation.setLongitude(67.284419);
            }
            case "gulistan" -> {
                sendLocation.setLatitude(40.496646);
                sendLocation.setLongitude(68.784239);
            }
            case "karshi" -> {
                sendLocation.setLatitude(38.8404064);
                sendLocation.setLongitude(65.7872986);
            }
            case "namangan" -> {
                sendLocation.setLatitude(40.9981918);
                sendLocation.setLongitude(71.5753579);
            }
        }

        return sendLocation;
    }
}
