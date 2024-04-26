package org.nbu.service;

import org.nbu.data.items.Detail;
import org.nbu.data.items.GetDetails;

public class SewingServiceImpl {

    public <T extends GetDetails> int sew(T item) {
        int sum = 0;
        for (Detail detail: item.getDetails()){
            sum += detail.getDifficultyLevel().getMinutesToSew();
        }
        return sum;
    }
}
