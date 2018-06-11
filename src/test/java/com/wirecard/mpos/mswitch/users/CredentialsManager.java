package com.wirecard.mpos.mswitch.users;

import net.serenitybdd.screenplay.actors.OnStage;

public class CredentialsManager {
    public static UserCredentials getCredentials() {
        String actorName = OnStage.theActorInTheSpotlight().getName();
        switch (actorName) {
            case "Jakub":
                return new SystemAdmin();

            default:
                throw new IllegalStateException("Credentials for actor " + actorName+ " not found");
        }
    }
}
