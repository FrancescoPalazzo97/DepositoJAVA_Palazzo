package org.francesco.demo.run;

import java.time.LocalDateTime;

public record RunRecord(
                Integer id,
                String title,
                LocalDateTime startedOn,
                LocalDateTime completedOn,
                Integer miles,
                Location location) {
        public RunRecord {
                if (miles < 0) {
                        miles = 0;
                        throw new IllegalArgumentException("Miles cannot be -1");
                }

                if (completedOn.isBefore(startedOn)) {
                        throw new IllegalArgumentException("Completed on must be after started on");
                }
        }
}
