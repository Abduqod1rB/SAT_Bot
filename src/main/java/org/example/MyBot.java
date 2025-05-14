package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
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
                case "/start", "⬅\uFE0F Menu" -> executeSafely(myBotService.menu(chatId));
                case "⬅️ Back" -> executeSafely(myBotService.sendLocation(chatId));
                case "📘 Math" -> sendMathTopics(chatId);
                case "📗 English" -> sendEnglishTopics(chatId);
                case "🧮 Desmos" -> sendText(chatId, "Desmos: https://www.desmos.com/calculator");
                case "📚 Vocabulary" -> sendVocabulary(chatId);
                case "📚  Old Real Exams" -> sendText(chatId, "<UNK> Old Real Exams");
                case "\uD83D\uDD17 Online Practice Platforms" -> {
                    sendText(chatId, "https://bluebook.plus");
                    sendText(chatId, "https://oneprep.fly.dev/");
                    sendText(chatId, "https://test-ninjas.com/digital-sat-score-calculator");
                }
                case "\uD83D\uDCCC Test Centers" -> executeSafely(myBotService.sendLocation(chatId));
                case "\uD83D\uDCDD Register for SAT" ->
                        sendText(chatId, "Registration service is not working at this time");
                case "\uD83D\uDCAC Contact Admin" -> sendText(chatId, "@abu_org");
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

        if (update.hasMessage() && update.getMessage().hasContact()) {
            SendMessage sendMessage = new SendMessage();
            Long chatId = update.getMessage().getChatId();
            String phoneNumber = update.getMessage().getContact().getPhoneNumber();
            String name = update.getMessage().getFrom().getFirstName();
            System.out.println(name + "\n" + phoneNumber);
            sendMessage.setChatId(chatId);
            try {
                execute(myBotService.menu(chatId));
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
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

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang:");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }

    private void sendEnglishTopics(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Reading").callbackData("algebra").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📗 Writing").callbackData("geometry").build()));

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

    private void executeSafely(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void executeDocument(SendDocument document) {
        try {
            execute(document);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
