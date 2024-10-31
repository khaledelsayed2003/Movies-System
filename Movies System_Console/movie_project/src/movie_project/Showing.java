package movie_project;

import java.time.LocalDateTime;

public class Showing {
    private LocalDateTime dateTime;
    private Cinema cinema;

    public Showing(LocalDateTime dateTime, Cinema cinema) {
        this.dateTime = dateTime;
        this.cinema = cinema;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}

