package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    static MyBotService myBotService = new MyBotService();

    @Override

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            switch (text) {
                case "/start", "⬅️ Menu" -> executeSafely(myBotService.menu(chatId));
                case "⬅️ Back", "\uD83D\uDCCC Test Centers" -> executeSafely(myBotService.sendLocation(chatId));
                case "📘 Math" -> sendMathTopics(chatId);
                case "📗 English" -> sendEnglishTopics(chatId);
                case "🧮 Desmos" -> sendText(chatId, "Desmos: https://www.desmos.com/calculator");
                case "📚 Vocabulary" -> sendVocabulary(chatId);
                case "\uD83D\uDCD4  Old Real Exams" -> executeSafely(myBotService.menuForExams(chatId));
                case "\uD83D\uDD17 Online Practice Platforms" -> {
                    sendText(chatId, "https://bluebook.plus");
                    sendText(chatId, "https://oneprep.fly.dev/");
                    sendText(chatId, "https://test-ninjas.com/digital-sat-score-calculator");
                }
                case "\uD83D\uDCDD Register for SAT" ->
                        sendText(chatId, "Registration service is not working at this time");
                case "\uD83D\uDCAC Contact Admin" -> sendText(chatId, "\uD83D\uDD27 Yordam kerakmi? Admin bilan bog‘lanish uchun bu yerga yozing:\n" +
                        "\uD83D\uDCEC @abu_org\n" +
                        "Iltimos, muammo yoki savolingizni aniq yozing — tez orada yordam beramiz!");
                case "\uD83D\uDCCC Others" -> executeSafely(myBotService.otherLocation(chatId));
                case "\uD83D\uDCCD Cambridge International College" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "cambridge"));
                    executeSafely(myBotService.sendLocMessage(chatId, "cambridge"));
                }
                case "\uD83D\uDCCD President School of Tashkent" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "president tashkent"));
                    executeSafely(myBotService.sendLocMessage(chatId, "president tashkent"));
                }
                case "\uD83D\uDCCD Sodiq school" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "sodiq"));
                    executeSafely(myBotService.sendLocMessage(chatId, "sodiq"));
                }
                case "\uD83D\uDCCD Tashkent International School" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "inter tashkent"));
                    executeSafely(myBotService.sendLocMessage(chatId, "inter tashkent"));
                }
                case "\uD83D\uDCCD Stars International University" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "stars"));
                    executeSafely(myBotService.sendLocMessage(chatId, "stars"));
                }
                case "\uD83D\uDCCD New Uzbekistan University" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "newUzb"));
                    executeSafely(myBotService.sendLocMessage(chatId, "newUzb"));
                }
                case "\uD83D\uDCCD Target International School" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "target"));
                    executeSafely(myBotService.sendLocMessage(chatId, "target"));
                }
                case "\uD83D\uDCCD Presidential School of Andijan" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "andijan"));
                    executeSafely(myBotService.sendLocMessage(chatId, "andijan"));
                }
                case "\uD83D\uDCCD President School of Djizzakh" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "djizzakh"));
                    executeSafely(myBotService.sendLocMessage(chatId, "djizzakh"));
                }
                case "\uD83D\uDCCD Presidential School of Khiva" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "khiva"));
                    executeSafely(myBotService.sendLocMessage(chatId, "khiva"));
                }
                case "\uD83D\uDCCD Innovative Center(Samarqand)" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "innovative"));
                    executeSafely(myBotService.sendLocMessage(chatId, "innovative"));
                }
                case "\uD83D\uDCCD Presidential School of Bukhara" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "bukhara"));
                    executeSafely(myBotService.sendLocMessage(chatId, "bukhara"));
                }
                case "\uD83D\uDCCD Presidential School of Fergana" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "fergana"));
                    executeSafely(myBotService.sendLocMessage(chatId, "fergana"));
                }
                case "\uD83D\uDCCD Presidential School of Navoiy" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "navoiy"));
                    executeSafely(myBotService.sendLocMessage(chatId, "navoiy"));
                }
                case "\uD83D\uDCCD Presidential School of Nukus" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "nukus"));
                    executeSafely(myBotService.sendLocMessage(chatId, "nukus"));
                }
                case "\uD83D\uDCCD Presidential School of Nurafshon" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "nurafshon"));
                    executeSafely(myBotService.sendLocMessage(chatId, "nurafshon"));
                }
                case "\uD83D\uDCCD Presidential School of Termez" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "termez"));
                    executeSafely(myBotService.sendLocMessage(chatId, "termez"));
                }
                case "\uD83D\uDCCD Presidential School of Gulistan" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "gulistan"));
                    executeSafely(myBotService.sendLocMessage(chatId, "gulistan"));
                }
                case "\uD83D\uDCCD Presidential School of Karshi" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "karshi"));
                    executeSafely(myBotService.sendLocMessage(chatId, "karshi"));
                }
                case "\uD83D\uDCCD Presidential School of Namangan" -> {
                    executeLoc(myBotService.sendExactLocation(chatId, "namangan"));
                    executeSafely(myBotService.sendLocMessage(chatId, "namangan"));
                }


                default -> sendText(chatId, "Iltimos, menyudagi tugmalardan foydalaning.");
            }
        }
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Long chatId = callbackQuery.getMessage().getChatId();
            String data = callbackQuery.getData();
            switch (data) {
                case "desmosSol" -> {

                    sendText(chatId, "Desmos Solution files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/14");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/15");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/16");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/17");

                }
                case "algebra" -> {

                    sendText(chatId, "Algebra files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/62");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/63");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/64");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/65");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/66");


                }
                case "advancedM" -> {

                    sendText(chatId, "Advanced Math Files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/55");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/56");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/57");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/58");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/59");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/60");
                }
                case "problemS" -> {
                    sendText(chatId, "Problem Solution files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/75");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/76");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/77");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/78");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/79");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/80");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/81");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/82");
                }
                case "reading" -> {
                    sendText(chatId, "Reading files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/25");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/29");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/27");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/26");
                }
                case "writing" -> {
                    sendText(chatId, "Writing files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/45");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/100");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/101");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/102");
                }
                case "geometry" -> {
                    sendText(chatId, "Geometry files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/72");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/70");
                }
                case "trigonometry" -> {
                    sendText(chatId, "Trigonometry files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/69");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/71");
                }
                case "mathVocab" -> {
                    sendText(chatId, "Math vocabulary files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/98");
                }
                case "englishVocab" -> {
                    sendText(chatId, "English vocabulary files: ");
                    sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/18");
                }
                case "answersEng"->{
                    sendText(chatId, "Answers for english files: ");
                    sendDocument(chatId,"https://t.me/SatMaterialsDFGHJKJHGFDFGBN/35");
                    sendDocument(chatId,"");
                }
                case "03.2024" -> sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/8");
                case "05.2024" -> sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/9");
                case "06.2024" -> sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/10");
                case "08.2024" -> sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/11");
                case "10.2024" -> sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/12");
                case "11.2024" -> sendDocument(chatId, "https://t.me/SatMaterialsDFGHJKJHGFDFGBN/13");
            }

        }
    }

    @Override
    public String getBotUsername() {
        return "SATmaterialsForStudents_bot";
    }

    @Override
    public String getBotToken() {
        return "7930871877:AAFr0AKNmn3Ce16dl4sYo60U9LbvbzB7WQ0";
    }


    private void sendMathTopics(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Algebra").callbackData("algebra").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Advanced Math").callbackData("advancedM").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Problem-Solving and Data Analysis").callbackData("problemS").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Geometry").callbackData("geometry").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Trigonometry").callbackData("trigonometry").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Desmos solutions").callbackData("desmosSol").build()));

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang:");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }

    private void sendDocument(Long chatId, String document) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setDocument(new InputFile(document));
        sendDocument.setChatId(chatId);
        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendEnglishTopics(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Reading").callbackData("reading").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📗 Writing").callbackData("writing").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("\uD83D\uDCD2 Answers").callbackData("answersEng").build()));

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang: ");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }

    private void sendVocabulary(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Math Vocabulary").callbackData("mathVocab").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📗 English Vocabulary").callbackData("englishVocab").build()));

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang: ");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }

    private void sendText(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        executeSafely(message);
    }

    private void executeLoc(SendLocation location) {
        try {
            execute(location);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void executeDelete(String chatId, Integer messageId) {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
        try {
            execute(deleteMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void executeSafely(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
