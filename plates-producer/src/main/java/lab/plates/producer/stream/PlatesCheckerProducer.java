package lab.plates.producer.stream;



import lab.plates.producer.proto.Plate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class PlatesCheckerProducer {

    @PollableBean
    public Supplier<Flux<Plate>> platesToCheck() {
        return () ->  Flux.fromIterable(getPlates());
    }

    private List<Plate> getPlates(){
        log.info("Sending 5 plates to topic");
        return List.of(
                Plate.newBuilder().setPlate("SIE7D3K").build(),
                Plate.newBuilder().setPlate("SIE7D4K").build(),
                Plate.newBuilder().setPlate("SIE7D5K").build(),
                Plate.newBuilder().setPlate("SIE7D6K").build(),
                Plate.newBuilder().setPlate("SIE7D7K").build()
        );
    }
}
