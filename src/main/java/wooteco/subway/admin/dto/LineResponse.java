package wooteco.subway.admin.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import wooteco.subway.admin.domain.Line;

public class LineResponse {

    private Long id;
    private String name;
    private String bgColor;
    private LocalTime startTime;
    private LocalTime endTime;
    private int intervalTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Set<StationResponse> stations;

    public LineResponse() {
    }

    public LineResponse(Long id, String name, String bgColor, LocalTime startTime, LocalTime endTime, int intervalTime,
        LocalDateTime createdAt, LocalDateTime updatedAt, Set<StationResponse> stations) {
        this.id = id;
        this.name = name;
        this.bgColor = bgColor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.stations = stations;
    }

    public static LineResponse of(Line line) {
        return new LineResponse(line.getId(), line.getName(), line.getBgColor(),
            line.getStartTime(), line.getEndTime(),
            line.getIntervalTime(), line.getCreatedAt(), line.getUpdatedAt(), new HashSet<>());
    }

    public static LineResponse of(Line line, Set<StationResponse> stationResponses) {
        return new LineResponse(line.getId(), line.getName(), line.getBgColor(),
            line.getStartTime(), line.getEndTime(),
            line.getIntervalTime(), line.getCreatedAt(), line.getUpdatedAt(), stationResponses);
    }

    public static List<LineResponse> listOf(List<Line> lines) {
        return lines.stream()
            .map(it -> LineResponse.of(it))
            .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBgColor() {
        return bgColor;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public Set<StationResponse> getStations() {
        return stations;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
