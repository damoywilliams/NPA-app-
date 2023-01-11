package ConsumingAPI.NBAapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/client")

public class controller {
    Service service;

    @Autowired
    public controller(Service service) {
     this.service=service;
    }



    @GetMapping("/live")

    public List<Game> live() throws URISyntaxException, IOException, InterruptedException {

    return service.getAllLive();

    }

@GetMapping("/today")
    public List<Game> Today() throws URISyntaxException, IOException, InterruptedException {
  service.date();


return service.date();
    }





}
