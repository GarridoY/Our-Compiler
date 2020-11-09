package dk.aau.cs.d703e20.uppaal;

import com.uppaal.engine.QueryFeedback;
import com.uppaal.engine.QueryResult;
import com.uppaal.model.system.concrete.ConcreteTransitionRecord;
import com.uppaal.model.system.symbolic.SymbolicTransition;

import java.util.ArrayList;

public class TimeFeedback implements QueryFeedback {
    @Override
    public void setProgressAvail(boolean availability) {
    }

    @Override
    public void setProgress(int load, long vm, long rss, long cached, long avail, long swap, long swapfree, long user, long sys, long timestamp) {
    }

    @Override
    public void setSystemInfo(long vmsize, long physsize, long swapsize) {
    }

    @Override
    public void setLength(int length) {
    }

    @Override
    public void setCurrent(int pos) {
    }

    @Override
    public void setTrace(char result, String feedback,
                         ArrayList<SymbolicTransition> trace, int cycle,
                         QueryResult queryVerificationResult) {
    }

    public void setTraceSMC(char result, String feedback,
                            ArrayList<ConcreteTransitionRecord> trace, int cycle,
                            QueryResult queryVerificationResult) {
    }

    @Override
    public void setFeedback(String feedback) {
        if (feedback != null && feedback.length() > 0) {
            System.out.println(feedback);
        }
    }

    @Override
    public void appendText(String s) {
        if (s != null && s.length() > 0) {
            System.out.println(s);
        }
    }

    @Override
    public void setResultText(String s) {
        if (s != null && s.length() > 0) {
            System.out.println(s);
        }
    }
}
