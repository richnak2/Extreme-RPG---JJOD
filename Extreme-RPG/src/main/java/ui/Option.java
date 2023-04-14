package ui;

// polozka v menu
// label - text, ktory sa zobrazi
// function - funkcia, ktora sa spusti, ked user zvoli polozku
public record Option(String label, Function function) {

    public void run() {
        function.run();
    }

}

