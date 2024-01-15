package router.potato.BattleshipsOnline.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import router.potato.BattleshipsOnline.model.Game;

public interface GameRepository extends MongoRepository<Game, String> {

}
