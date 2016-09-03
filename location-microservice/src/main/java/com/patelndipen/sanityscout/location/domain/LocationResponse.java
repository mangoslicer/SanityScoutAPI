package com.patelndipen.sanityscout.location.domain;

import javax.validation.constraints.NotNull;

public class LocationResponse {
    @NotNull
    private Location location;

    public LocationResponse(@NotNull Location l) {
        this.location = l;
    }

    @NotNull
    public Location getLocation() {
        return this.location;
    }

}
