package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.api.config.MatchConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MatchRecord;

import java.util.List;

/**
 * This represents a single PVP match.  It may be persisted for record keeping.
 */
public interface Match {

    /**
     *
     * @return
     */
    List<Team> getTeams();
    
    MatchConfig config();
    
    MatchRecord record();

    /**
     * An interface for Builder classes to be used in implementations of {@link Match}.
     */
    public static interface MatchBuilder {
        
        Match build();

    }

}
