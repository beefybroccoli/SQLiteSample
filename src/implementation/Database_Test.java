/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.util.ArrayList;
import java.util.List;
import sqlite_demonstration.SQLiteDatabase;

/**
 *
 * @author macbook
 */
public class Database_Test {

    public static void main(String[] args) {

        runTest();

        //getQueryArray();
    }

    public static void runTest() {
        SQLiteDatabase db = new SQLiteDatabase();

        db.createTable(referenceQuery());
    }

    public static List<String> getQueryArray() {
        List<String> result = new ArrayList<String>();
        String massInputQueries = massInputQueries();

        String[] stringArray = massInputQueries.split(";");
        for (String element : stringArray) {
            int startIndex = element.indexOf("CREATE");
            element = element.substring(startIndex) + ";";
            element = element.replaceAll("IF NOT EXISTS ", "");
            element = element.replaceAll("LONGTEXT ", "TEXT");
            element = element.replaceAll("`", "");
            System.out.println("element : " + element + "\n");
            result.add(element);
        }

        return result;
    }

    public static String referenceQuery() {
        return "CREATE TABLE COMPANY "
                + "(ID INT PRIMARY KEY     NOT NULL,"
                + " NAME           TEXT    NOT NULL, "
                + " AGE            INT     NOT NULL, "
                + " ADDRESS        CHAR(50), "
                + " SALARY         REAL)";
    }

    public static String massInputQueries() {
        return "-- -----------------------------------------------------\n" +
"-- Table `origin`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `origin` (\n" +
"  `character_set` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `profiles` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  PRIMARY KEY (`id`));\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `character`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `character` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `birth` DATE NULL,\n" +
"  `character_enemies` LONGTEXT NULL,\n" +
"  `character_friends` LONGTEXT NULL,\n" +
"  `count_of_issue_appearances` INT NULL,\n" +
"  `creators` LONGTEXT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `first_appeared_in_issue` LONGTEXT NULL,\n" +
"  `gender` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_credits` LONGTEXT NULL,\n" +
"  `issues_died_in` LONGTEXT NULL,\n" +
"  `movies` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `origin` LONGTEXT NULL,\n" +
"  `powers` LONGTEXT NULL,\n" +
"  `publisher` LONGTEXT NULL,\n" +
"  `real_name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `story_arc_credits` LONGTEXT NULL,\n" +
"  `team_enemies` LONGTEXT NULL,\n" +
"  `team_friends` LONGTEXT NULL,\n" +
"  `teams` LONGTEXT NULL,\n" +
"  `volume_credits` LONGTEXT NULL,\n" +
"  `origin_id`  NOT NULL,\n" +
"  PRIMARY KEY (`id`, `origin_id`),\n" +
"  INDEX `fk_character_origin1_idx` (`origin_id` ASC),\n" +
"  CONSTRAINT `fk_character_origin1`\n" +
"    FOREIGN KEY (`origin_id`)\n" +
"    REFERENCES `origin` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `location`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `location` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `count_of_issue_appearances` INT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `first_appeared_in_issue` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_credits` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `start_year` INT NULL,\n" +
"  `story_arc_credits` LONGTEXT NULL,\n" +
"  `volume_credits` LONGTEXT NULL,\n" +
"  PRIMARY KEY (`id`));\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `volume`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `volume` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `character_credits` LONGTEXT NULL,\n" +
"  `concept_credits` LONGTEXT NULL,\n" +
"  `count_of_issues` LONGTEXT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `first_issue` DATE NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `last_issue` LONGTEXT NULL,\n" +
"  `location_credits` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `object_credits` LONGTEXT NULL,\n" +
"  `person_credits` LONGTEXT NULL,\n" +
"  `publisher` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `start_year` LONGTEXT NULL,\n" +
"  `team_credits` LONGTEXT NULL,\n" +
"  `location_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`id`, `location_id`),\n" +
"  INDEX `fk_volume_location1_idx` (`location_id` ASC),\n" +
"  CONSTRAINT `fk_volume_location1`\n" +
"    FOREIGN KEY (`location_id`)\n" +
"    REFERENCES `location` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `publisher`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `publisher` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `characters` LONGTEXT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `location_address` LONGTEXT NULL,\n" +
"  `location_city` LONGTEXT NULL,\n" +
"  `location_state` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `story_arcs` LONGTEXT NULL,\n" +
"  `teams` LONGTEXT NULL,\n" +
"  `volumes` LONGTEXT NULL,\n" +
"  `volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`id`, `volume_id`),\n" +
"  INDEX `fk_publisher_volume1_idx` (`volume_id` ASC),\n" +
"  CONSTRAINT `fk_publisher_volume1`\n" +
"    FOREIGN KEY (`volume_id`)\n" +
"    REFERENCES `volume` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `person`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `person` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `birth` DATE NULL,\n" +
"  `count_of_issue_appearances` LONGTEXT NULL,\n" +
"  `country` LONGTEXT NULL,\n" +
"  `created_characters` LONGTEXT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `death` TINYINT(1) NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `email` LONGTEXT NULL,\n" +
"  `gender` LONGTEXT NULL,\n" +
"  `hometown` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_credits` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `story_arc_credits` LONGTEXT NULL,\n" +
"  `volume_credits` LONGTEXT NULL,\n" +
"  `website` LONGTEXT NULL,\n" +
"  `volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`id`, `volume_id`),\n" +
"  INDEX `fk_person_volume1_idx` (`volume_id` ASC),\n" +
"  CONSTRAINT `fk_person_volume1`\n" +
"    FOREIGN KEY (`volume_id`)\n" +
"    REFERENCES `volume` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `people`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `people` (\n" +
"  `limit`  NULL,\n" +
"  `offset`  NULL,\n" +
"  `sort`  NULL,\n" +
"  `filter`  NULL,\n" +
"  `website`  NULL,\n" +
"  `aliases`  NULL,\n" +
"  `birth`  NULL,\n" +
"  `count_of_issue_appearances`  NULL,\n" +
"  `country`  NULL,\n" +
"  `date_added`  NULL,\n" +
"  `date_last_updated`  NULL,\n" +
"  `death`  NULL,\n" +
"  `deck`  NULL,\n" +
"  `description`  NULL,\n" +
"  `email`  NULL,\n" +
"  `gender`  NULL,\n" +
"  `hometown`  NULL,\n" +
"  `id`  NULL,\n" +
"  `image`  NULL,\n" +
"  `name`  NULL,\n" +
"  `site_detail_url`  NULL);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `team`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `team` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `character_enemies` LONGTEXT NULL,\n" +
"  `character_friends` LONGTEXT NULL,\n" +
"  `characters` LONGTEXT NULL,\n" +
"  `count_of_issue_appearances` INT NULL,\n" +
"  `count_of_team_members` INT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `disbanded_in_issues` LONGTEXT NULL,\n" +
"  `first_appeared_in_issue` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_credits` LONGTEXT NULL,\n" +
"  `issues_disbanded_in` LONGTEXT NULL,\n" +
"  `movies` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `publisher` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `story_arc_credits` LONGTEXT NULL,\n" +
"  `volume_credits` LONGTEXT NULL,\n" +
"  PRIMARY KEY (`id`));\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `series`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `series` (\n" +
"  `aliases`  NULL,\n" +
"  `character_credits`  NULL,\n" +
"  `count_of_episodes`  NULL,\n" +
"  `date_added`  NULL,\n" +
"  `date_last_updated`  NULL,\n" +
"  `deck`  NULL,\n" +
"  `description`  NULL,\n" +
"  `first_episode`  NULL,\n" +
"  `id`  NULL,\n" +
"  `image`  NULL,\n" +
"  `last_episode`  NULL,\n" +
"  `location_credits`  NULL,\n" +
"  `name`  NULL,\n" +
"  `publisher`  NULL,\n" +
"  `site_detail_url`  NULL,\n" +
"  `start_year`  NULL);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `story_arc`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `story_arc` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `count_of_issue_appearances` INT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `first_appeared_in_issue` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issues` LONGTEXT NULL,\n" +
"  `movies` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `publisher` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`id`, `volume_id`),\n" +
"  INDEX `fk_story_arc_volume1_idx` (`volume_id` ASC),\n" +
"  CONSTRAINT `fk_story_arc_volume1`\n" +
"    FOREIGN KEY (`volume_id`)\n" +
"    REFERENCES `volume` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `concept`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `concept` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `count_of_issue_appearances` INT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `first_appeared_in_issue` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_credits` LONGTEXT NULL,\n" +
"  `movies` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `start_year` LONGTEXT NULL,\n" +
"  `volume_credits` LONGTEXT NULL,\n" +
"  `volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`id`, `volume_id`),\n" +
"  INDEX `fk_concept_volume1_idx` (`volume_id` ASC),\n" +
"  CONSTRAINT `fk_concept_volume1`\n" +
"    FOREIGN KEY (`volume_id`)\n" +
"    REFERENCES `volume` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `episode`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `episode` (\n" +
"  `aliases`  NULL,\n" +
"  `character_credits`  NULL,\n" +
"  `characters_died_in`  NULL,\n" +
"  `concept_credits`  NULL,\n" +
"  `air_date`  NULL,\n" +
"  `date_added`  NULL,\n" +
"  `date_last_updated`  NULL,\n" +
"  `deck`  NULL,\n" +
"  `description`  NULL,\n" +
"  `first_appearance_characters`  NULL,\n" +
"  `first_appearance_concepts`  NULL,\n" +
"  `first_appearance_locations`  NULL,\n" +
"  `first_appearance_objects`  NULL,\n" +
"  `first_appearance_storyarcs`  NULL,\n" +
"  `first_appearance_teams`  NULL,\n" +
"  `has_staff_review`  NULL,\n" +
"  `id`  NULL,\n" +
"  `image`  NULL,\n" +
"  `episode_number`  NULL,\n" +
"  `location_credits`  NULL,\n" +
"  `name`  NULL,\n" +
"  `object_credits`  NULL,\n" +
"  `person_credits`  NULL,\n" +
"  `site_detail_url`  NULL,\n" +
"  `story_arc_credits`  NULL,\n" +
"  `team_credits`  NULL,\n" +
"  `series`  NULL);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `movie`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `movie` (\n" +
"  `box_office_revenue`  NULL,\n" +
"  `budget`  NULL,\n" +
"  `characters`  NULL,\n" +
"  `concepts`  NULL,\n" +
"  `date_added`  NULL,\n" +
"  `date_last_updated`  NULL,\n" +
"  `deck`  NULL,\n" +
"  `description`  NULL,\n" +
"  `distributor`  NULL,\n" +
"  `has_staff_review`  NULL,\n" +
"  `id`  NULL,\n" +
"  `image`  NULL,\n" +
"  `locations`  NULL,\n" +
"  `name`  NULL,\n" +
"  `producers`  NULL,\n" +
"  `rating`  NULL,\n" +
"  `release_date`  NULL,\n" +
"  `runtime`  NULL,\n" +
"  `site_detail_url`  NULL,\n" +
"  `studios`  NULL,\n" +
"  `teams`  NULL,\n" +
"  `things`  NULL,\n" +
"  `total_revenue`  NULL,\n" +
"  `writers`  NULL);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `issue`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `issue` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `character_credits` LONGTEXT NULL,\n" +
"  `characters_died_in` LONGTEXT NULL,\n" +
"  `concept_credits` LONGTEXT NULL,\n" +
"  `cover_date` DATE NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `disbanded_teams` LONGTEXT NULL,\n" +
"  `first_appearance_characters` LONGTEXT NULL,\n" +
"  `first_appearance_concepts` LONGTEXT NULL,\n" +
"  `first_appearance_locations` LONGTEXT NULL,\n" +
"  `first_appearance_objects` LONGTEXT NULL,\n" +
"  `first_appearance_storyarcs` LONGTEXT NULL,\n" +
"  `first_appearance_teams` LONGTEXT NULL,\n" +
"  `has_staff_review` TINYINT(1) NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_number` INT NULL,\n" +
"  `location_credits` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `object_credits` LONGTEXT NULL,\n" +
"  `person_credits` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `store_date` DATE NULL,\n" +
"  `story_arc_credits` LONGTEXT NULL,\n" +
"  `team_credits` LONGTEXT NULL,\n" +
"  `volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`id`, `volume_id`),\n" +
"  INDEX `fk_issue_volume_idx` (`volume_id` ASC),\n" +
"  CONSTRAINT `fk_issue_volume`\n" +
"    FOREIGN KEY (`volume_id`)\n" +
"    REFERENCES `volume` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `object`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `object` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `count_of_issue_appearances` INT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `deck` LONGTEXT NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `first_appeared_in_issue` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `image` LONGTEXT NULL,\n" +
"  `issue_credits` LONGTEXT NULL,\n" +
"  `movies` LONGTEXT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  `start_year` INT NULL,\n" +
"  `story_arc_credits` LONGTEXT NULL,\n" +
"  `volume_credits` LONGTEXT NULL,\n" +
"  PRIMARY KEY (`id`));\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `power`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `power` (\n" +
"  `aliases` LONGTEXT NULL,\n" +
"  `characters` LONGTEXT NULL,\n" +
"  `date_added` DATE NULL,\n" +
"  `date_last_updated` DATE NULL,\n" +
"  `description` LONGTEXT NULL,\n" +
"  `id` INT NOT NULL,\n" +
"  `name` LONGTEXT NULL,\n" +
"  `site_detail_url` LONGTEXT NULL,\n" +
"  PRIMARY KEY (`id`));\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `character_has_issue`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `character_has_issue` (\n" +
"  `character_id` INT NOT NULL,\n" +
"  `issue_id` INT NOT NULL,\n" +
"  `issue_volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`character_id`, `issue_id`, `issue_volume_id`),\n" +
"  INDEX `fk_character_has_issue_issue1_idx` (`issue_id` ASC, `issue_volume_id` ASC),\n" +
"  INDEX `fk_character_has_issue_character1_idx` (`character_id` ASC),\n" +
"  CONSTRAINT `fk_character_has_issue_character1`\n" +
"    FOREIGN KEY (`character_id`)\n" +
"    REFERENCES `character` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_character_has_issue_issue1`\n" +
"    FOREIGN KEY (`issue_id` , `issue_volume_id`)\n" +
"    REFERENCES `issue` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `team_has_character`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `team_has_character` (\n" +
"  `team_id` INT NOT NULL,\n" +
"  `character_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`team_id`, `character_id`),\n" +
"  INDEX `fk_team_has_character_character1_idx` (`character_id` ASC),\n" +
"  INDEX `fk_team_has_character_team1_idx` (`team_id` ASC),\n" +
"  CONSTRAINT `fk_team_has_character_team1`\n" +
"    FOREIGN KEY (`team_id`)\n" +
"    REFERENCES `team` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_team_has_character_character1`\n" +
"    FOREIGN KEY (`character_id`)\n" +
"    REFERENCES `character` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `character_has_power`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `character_has_power` (\n" +
"  `character_id` INT NOT NULL,\n" +
"  `power_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`character_id`, `power_id`),\n" +
"  INDEX `fk_character_has_power_power1_idx` (`power_id` ASC),\n" +
"  INDEX `fk_character_has_power_character1_idx` (`character_id` ASC),\n" +
"  CONSTRAINT `fk_character_has_power_character1`\n" +
"    FOREIGN KEY (`character_id`)\n" +
"    REFERENCES `character` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_character_has_power_power1`\n" +
"    FOREIGN KEY (`power_id`)\n" +
"    REFERENCES `power` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `object_has_character`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `object_has_character` (\n" +
"  `object_id`  NOT NULL,\n" +
"  `character_id`  NOT NULL,\n" +
"  PRIMARY KEY (`object_id`, `character_id`),\n" +
"  INDEX `fk_object_has_character_character1_idx` (`character_id` ASC),\n" +
"  INDEX `fk_object_has_character_object1_idx` (`object_id` ASC),\n" +
"  CONSTRAINT `fk_object_has_character_object1`\n" +
"    FOREIGN KEY (`object_id`)\n" +
"    REFERENCES `object` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_object_has_character_character1`\n" +
"    FOREIGN KEY (`character_id`)\n" +
"    REFERENCES `character` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `issue_has_person`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `issue_has_person` (\n" +
"  `issue_id` INT NOT NULL,\n" +
"  `issue_volume_id` INT NOT NULL,\n" +
"  `person_id` INT NOT NULL,\n" +
"  `person_volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`issue_id`, `issue_volume_id`, `person_id`, `person_volume_id`),\n" +
"  INDEX `fk_issue_has_person_person1_idx` (`person_id` ASC, `person_volume_id` ASC),\n" +
"  INDEX `fk_issue_has_person_issue1_idx` (`issue_id` ASC, `issue_volume_id` ASC),\n" +
"  CONSTRAINT `fk_issue_has_person_issue1`\n" +
"    FOREIGN KEY (`issue_id` , `issue_volume_id`)\n" +
"    REFERENCES `issue` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_issue_has_person_person1`\n" +
"    FOREIGN KEY (`person_id` , `person_volume_id`)\n" +
"    REFERENCES `person` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `issue_has_concept`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `issue_has_concept` (\n" +
"  `issue_id` INT NOT NULL,\n" +
"  `issue_volume_id` INT NOT NULL,\n" +
"  `concept_id` INT NOT NULL,\n" +
"  `concept_volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`issue_id`, `issue_volume_id`, `concept_id`, `concept_volume_id`),\n" +
"  INDEX `fk_issue_has_concept_concept1_idx` (`concept_id` ASC, `concept_volume_id` ASC),\n" +
"  INDEX `fk_issue_has_concept_issue1_idx` (`issue_id` ASC, `issue_volume_id` ASC),\n" +
"  CONSTRAINT `fk_issue_has_concept_issue1`\n" +
"    FOREIGN KEY (`issue_id` , `issue_volume_id`)\n" +
"    REFERENCES `issue` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_issue_has_concept_concept1`\n" +
"    FOREIGN KEY (`concept_id` , `concept_volume_id`)\n" +
"    REFERENCES `concept` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `location_has_publisher`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `location_has_publisher` (\n" +
"  `location_id` INT NOT NULL,\n" +
"  `publisher_id` INT NOT NULL,\n" +
"  `publisher_volume_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`location_id`, `publisher_id`, `publisher_volume_id`),\n" +
"  INDEX `fk_location_has_publisher_publisher1_idx` (`publisher_id` ASC, `publisher_volume_id` ASC),\n" +
"  INDEX `fk_location_has_publisher_location1_idx` (`location_id` ASC),\n" +
"  CONSTRAINT `fk_location_has_publisher_location1`\n" +
"    FOREIGN KEY (`location_id`)\n" +
"    REFERENCES `location` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_location_has_publisher_publisher1`\n" +
"    FOREIGN KEY (`publisher_id` , `publisher_volume_id`)\n" +
"    REFERENCES `publisher` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);\n" +
"\n" +
"\n" +
"-- -----------------------------------------------------\n" +
"-- Table `issue_has_location`\n" +
"-- -----------------------------------------------------\n" +
"CREATE TABLE IF NOT EXISTS `issue_has_location` (\n" +
"  `issue_id` INT NOT NULL,\n" +
"  `issue_volume_id` INT NOT NULL,\n" +
"  `location_id` INT NOT NULL,\n" +
"  PRIMARY KEY (`issue_id`, `issue_volume_id`, `location_id`),\n" +
"  INDEX `fk_issue_has_location_location1_idx` (`location_id` ASC),\n" +
"  INDEX `fk_issue_has_location_issue1_idx` (`issue_id` ASC, `issue_volume_id` ASC),\n" +
"  CONSTRAINT `fk_issue_has_location_issue1`\n" +
"    FOREIGN KEY (`issue_id` , `issue_volume_id`)\n" +
"    REFERENCES `issue` (`id` , `volume_id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `fk_issue_has_location_location1`\n" +
"    FOREIGN KEY (`location_id`)\n" +
"    REFERENCES `location` (`id`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);";
    }

}
