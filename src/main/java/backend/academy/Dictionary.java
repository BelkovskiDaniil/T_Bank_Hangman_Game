package backend.academy;

import java.util.Map;
import java.util.Random;
import lombok.Getter;
import static backend.academy.ConstantsGallows.THEME_DEV;
import static backend.academy.ConstantsGallows.THEME_RELIGION;
import static backend.academy.ConstantsGallows.THEME_WAR;

public final class Dictionary {

    private Dictionary() {
    }

    @SuppressWarnings("unchecked")
    @Getter
    private final static Map<String, String>[] WORDS_WAR = new Map[] {
        Map.ofEntries(
            Map.entry("battle", "A fight between armed forces."),
            Map.entry("combat", "Fighting between armed forces."),
            Map.entry("attack", "An aggressive move to harm the enemy."),
            Map.entry("defend", "Protect from harm or danger."),
            Map.entry("weapon", "A tool used to inflict damage or defend."),
            Map.entry("troops", "Soldiers or armed forces."),
            Map.entry("strike", "A sudden attack, especially by air."),
            Map.entry("assault", "A violent attack or onslaught."),
            Map.entry("charge", "A rush forward to attack."),
            Map.entry("forces", "Military troops or soldiers."),
            Map.entry("marine", "A member of the naval infantry."),
            Map.entry("sniper", "A skilled marksman who shoots at long range."),
            Map.entry("tactic", "A specific action or strategy in battle."),
            Map.entry("victor", "The winner of a battle or war."),
            Map.entry("wounds", "Injuries caused in combat."),
            Map.entry("rifles", "Long-barreled guns used by infantry."),
            Map.entry("planes", "Aircraft used in combat."),
            Map.entry("missile", "A guided rocket weapon."),
            Map.entry("rocket", "An unguided projectile weapon."),
            Map.entry("patrol", "To monitor an area for enemies."),
            Map.entry("raider", "A soldier or vehicle that makes quick attacks."),
            Map.entry("ambush", "A surprise attack from a concealed position."),
            Map.entry("bunker", "A reinforced underground shelter."),
            Map.entry("cannon", "A large artillery gun."),
            Map.entry("medics", "Medical personnel who treat wounded soldiers."),
            Map.entry("warfare", "Engagement in or the activities involved in war."),
            Map.entry("warrior", "A person who fights in battles.")
        ),
        Map.ofEntries(
            Map.entry("battlefield", "The area where a battle takes place."),
            Map.entry("artillery", "Large-caliber guns used in warfare."),
            Map.entry("infantry", "Soldiers marching or fighting on foot."),
            Map.entry("paratrooper", "A soldier trained to parachute into an operation."),
            Map.entry("commander", "An officer in charge of a military unit."),
            Map.entry("operation", "A coordinated military action or mission."),
            Map.entry("reinforce", "To strengthen military forces."),
            Map.entry("evacuation", "The removal of people or troops from a dangerous area."),
            Map.entry("intelligence", "Information gathered for military purposes."),
            Map.entry("ammunition", "Projectiles and explosives used in combat."),
            Map.entry("explosives", "Materials that cause explosions."),
            Map.entry("resistance", "The refusal to accept defeat or surrender."),
            Map.entry("mobilization", "The act of assembling and preparing military forces."),
            Map.entry("occupation", "The control of a territory by foreign military forces."),
            Map.entry("surrender", "To give up and cease fighting."),
            Map.entry("casualties", "Soldiers who are killed, wounded, or missing."),
            Map.entry("deployment", "The movement of troops or equipment to a place."),
            Map.entry("detonation", "The act of causing an explosive device to explode."),
            Map.entry("insurgency", "A rebellion against a governing authority."),
            Map.entry("militarism", "The belief in maintaining a strong military capability."),
            Map.entry("munition", "Military weapons, ammunition, and equipment."),
            Map.entry("regiment", "A unit of the army commanded by a colonel."),
            Map.entry("submarine", "An underwater naval vessel."),
            Map.entry("territory", "An area under the jurisdiction of a military power."),
            Map.entry("veterans", "Former members of the armed forces.")
        ),
        Map.ofEntries(
            Map.entry("counteroffensive", "An attack made in response to one by an enemy."),
            Map.entry("demilitarization", "The reduction or removal of military forces."),
            Map.entry("international", "Involving two or more countries."),
            Map.entry("militarization", "The process of equipping or preparing for war."),
            Map.entry("multinational", "Involving several different countries."),
            Map.entry("reconstruction", "The rebuilding of a country after a war."),
            Map.entry("revolutionary", "Involving or causing a complete or dramatic change."),
            Map.entry("counterinsurgency", "Actions taken to defeat an insurgency."),
            Map.entry("decontamination", "The process of removing contaminants."),
            Map.entry("demobilization", "The discharge of troops from military service."),
            Map.entry("fortifications", "Military constructions designed for defense."),
            Map.entry("reconnaissance", "Military observation of a region to locate an enemy."),
            Map.entry("reinforcement", "Additional troops or materials to strengthen forces.")
        )
    };

    @SuppressWarnings("unchecked")
    @Getter
    private final static Map<String, String>[] WORDS_DEV = new Map[]{
        Map.ofEntries(
            Map.entry("coding", "The process of writing computer programs."),
            Map.entry("script", "A file containing code written in a scripting language."),
            Map.entry("method", "A function associated with an object in programming."),
            Map.entry("object", "An instance of a class in object-oriented programming."),
            Map.entry("syntax", "The set of rules that defines the structure of a language."),
            Map.entry("module", "A self-contained piece of code that provides specific functionality."),
            Map.entry("import", "The action of including code from another module or library."),
            Map.entry("export", "The process of making a module or object available for use in other files."),
            Map.entry("branch", "A separate line of development in version control."),
            Map.entry("commit", "A saved change or set of changes in version control."),
            Map.entry("deploy", "The process of releasing a software application to a production environment."),
            Map.entry("server", "A computer or program that provides data or services to other computers."),
            Map.entry("client", "A computer or program that accesses services provided by a server."),
            Map.entry("binary", "A base-2 numeral system used in computing."),
            Map.entry("string", "A sequence of characters used to represent text."),
            Map.entry("buffer", "A temporary data storage used to accommodate data flow."),
            Map.entry("thread", "A sequence of executable commands that can run concurrently."),
            Map.entry("socket", "An endpoint for sending or receiving data across a network."),
            Map.entry("widget", "A graphical control element in a user interface."),
            Map.entry("plugin", "A software component that adds specific features to an existing application."),
            Map.entry("filter", "A tool or function that processes data to meet certain criteria."),
            Map.entry("editor", "A program used for editing code or text."),
            Map.entry("layout", "The arrangement of elements in a graphical user interface."),
            Map.entry("schema", "The structure that defines the organization of data."),
            Map.entry("cursor", "A pointer that indicates a position within text or data."),
            Map.entry("driver", "A software component that allows the operating system to communicate with hardware."),
            Map.entry("parser", "A tool that analyzes and converts input data into a readable format."),
            Map.entry("vector", "An array-like data structure used in mathematics and graphics."),
            Map.entry("lambda", "An anonymous function defined within code.")
        ),
        Map.ofEntries(
            Map.entry("algorithm", "A step-by-step procedure for solving a problem or performing a task."),
            Map.entry("framework", "A platform for developing software applications."),
            Map.entry("interface", "A shared boundary between two components that enables communication."),
            Map.entry("iteration", "The repetition of a process in programming."),
            Map.entry("namespace", "A container that holds a set of identifiers for entities."),
            Map.entry("repository", "A storage location for software packages or code."),
            Map.entry("dependency", "A piece of code or library that another program requires to function."),
            Map.entry("exception", "An error condition that disrupts the normal flow of execution."),
            Map.entry("parameter", "A variable used to pass information into functions or methods."),
            Map.entry("prototype", "An early sample or model of software used for testing."),
            Map.entry("simulation", "The imitation of a real-world process or system over time."),
            Map.entry("validation", "The process of checking data for correctness."),
            Map.entry("automation", "The technique of making a process operate automatically."),
            Map.entry("compilation", "The process of converting source code into executable code."),
            Map.entry("encryption", "The process of converting data into a secure format."),
            Map.entry("expression", "A combination of variables, operators, and values in programming."),
            Map.entry("generation", "The creation of data or code."),
            Map.entry("integration", "The process of combining components or systems to function together."),
            Map.entry("optimization", "The process of making code more efficient."),
            Map.entry("refactoring", "The process of restructuring code without changing its behavior."),
            Map.entry("resolution", "The process of determining the outcome of a decision or conflict."),
            Map.entry("scripting", "Writing small programs to automate tasks."),
            Map.entry("statement", "A single line of code that performs a specific action."),
            Map.entry("technology", "The application of scientific knowledge for practical purposes."),
            Map.entry("transaction", "A sequence of operations that are executed as a single unit."),
            Map.entry("transpiler", "A tool that converts code from one programming language to another."),
            Map.entry("visualizer", "A tool or software used to create visual representations of data."),
            Map.entry("workaround", "A temporary solution to a problem or limitation in software.")
        ),
        Map.ofEntries(
            Map.entry("authentication", "The process of verifying the identity of a user."),
            Map.entry("configuration", "The arrangement of settings to control software behavior."),
            Map.entry("decompilation", "The reverse process of converting executable code back to source code."),
            Map.entry("documentation", "Written descriptions of software or procedures."),
            Map.entry("implementation", "The process of putting a design or plan into effect."),
            Map.entry("initialization", "The process of setting a variable or object to a valid state."),
            Map.entry("interoperability", "The ability of different systems to work together."),
            Map.entry("multithreading", "The use of multiple threads to perform tasks concurrently."),
            Map.entry("object-oriented", "A programming paradigm based on the concept of objects."),
            Map.entry("parameterization", "The process of defining parameters to make software more flexible."),
            Map.entry("preprocessing", "Processing data before the main process is executed."),
            Map.entry("reconfiguration", "Changing the setup of a system or software."),
            Map.entry("serialization", "The process of converting an object into a format "
                + "for storage or transmission."),
            Map.entry("synchronization", "The coordination of processes to work in unison."),
            Map.entry("troubleshooting", "The process of diagnosing and fixing problems."),
            Map.entry("virtualization", "Creating a virtual version of a resource or environment."),
            Map.entry("compatibility", "The ability of software or hardware to work together."),
            Map.entry("decentralization", "Distributing functions away from a central authority."),
            Map.entry("decomposition", "Breaking down a complex problem into simpler parts."),
            Map.entry("deserialization", "The process of converting serialized data back into an object."),
            Map.entry("internationalization", "Designing software to be adaptable to different languages and regions."),
            Map.entry("microcontroller", "A small computer on a single integrated circuit."),
            Map.entry("microservices", "An architectural style that structures an "
                + "application as a collection of small services."),
            Map.entry("reimplementation", "Implementing a system again, often for optimization or new features."),
            Map.entry("reinitialization", "Resetting a variable or object to its initial state."),
            Map.entry("restructuring", "Changing the organization of software code."),
            Map.entry("transformation", "Changing data from one format or structure to another.")
        )
    };

    @SuppressWarnings("unchecked")
    @Getter
    private final static Map<String, String>[] WORDS_RELIGION = new Map[]{
        Map.ofEntries(
            Map.entry("prayer", "A solemn request or expression of thanks to a deity."),
            Map.entry("church", "A building used for public Christian worship."),
            Map.entry("temple", "A building dedicated to the worship of a god or gods."),
            Map.entry("mosque", "A Muslim place of worship."),
            Map.entry("saints", "Individuals recognized as having an exceptional"
                + " degree of holiness or likeness to God."),
            Map.entry("deacon", "An ordained minister of an order ranking below that of a priest."),
            Map.entry("shrine", "A place regarded as holy because of its"
                + " associations with a divinity or a sacred person or relic."),
            Map.entry("spirit", "The non-physical part of a person which is "
                + "the seat of emotions and character; the soul."),
            Map.entry("ritual", "A religious or solemn ceremony consisting of "
                + "a series of actions performed according to a prescribed order."),
            Map.entry("mantra", "A word or sound repeated to aid concentration "
                + "in meditation, especially in Hinduism and Buddhism."),
            Map.entry("sermon", "A talk on a religious or moral subject, typically given during a church service."),
            Map.entry("worship", "The feeling or expression of reverence and adoration for a deity."),
            Map.entry("belief", "An acceptance that something exists or is true, especially without proof."),
            Map.entry("divine", "Of or like God or a god."),
            Map.entry("sacred", "Connected with God or a god; considered to be holy."),
            Map.entry("clergy", "The body of all people ordained for "
                + "religious duties, especially in the Christian Church."),
            Map.entry("gospel", "The teaching or revelation of Christ."),
            Map.entry("hymnal", "A book of hymns used in religious services."),
            Map.entry("prophet", "A person regarded as an inspired teacher or proclaimer of the will of God.")
        ),
        Map.ofEntries(
            Map.entry("religion", "A system of faith and worship."),
            Map.entry("spiritual", "Relating to or affecting the human spirit or soul."),
            Map.entry("sacrifice", "An act of offering something precious to a deity."),
            Map.entry("pilgrimage", "A journey to a sacred place for religious reasons."),
            Map.entry("meditation", "A practice where an individual uses a technique to focus the mind."),
            Map.entry("scripture", "The sacred writings of a religion."),
            Map.entry("cathedral", "A principal church of a diocese, containing the bishop's throne."),
            Map.entry("monastery", "A building or buildings occupied by a"
                + " community of monks living under religious vows."),
            Map.entry("synagogue", "A Jewish house of worship, often having facilities for religious instruction."),
            Map.entry("revelation", "A divine truth disclosed by God to humans."),
            Map.entry("salvation", "Deliverance from sin and its consequences, often believed "
                + "to be brought about by faith in Christ."),
            Map.entry("redemption", "The action of saving or being saved from sin, error, or evil."),
            Map.entry("sacrament", "A religious ceremony or act that is regarded as an"
                + " outward and visible sign of inward and spiritual divine grace."),
            Map.entry("tradition", "A belief or behavior passed down within a group or society with symbolic meaning."),
            Map.entry("devotional", "Related to prayer, worship, or devotion to a deity."),
            Map.entry("evangelism", "The spreading of the Christian gospel by public preaching or personal witness."),
            Map.entry("proselyte", "A person who has converted from one religion to another."),
            Map.entry("theology", "The study of the nature of God and religious belief."),
            Map.entry("doctrine", "A belief or set of beliefs held and taught by a church."),
            Map.entry("liturgical", "Relating to public worship or liturgies."),
            Map.entry("sanctuary", "A place of refuge or safety, especially in a religious context."),
            Map.entry("tabernacle", "A fixed or movable dwelling, especially a tent used as a sanctuary."),
            Map.entry("transcend", "To go beyond the range or limits of something."),
            Map.entry("veneration", "Great respect or reverence towards something holy."),
            Map.entry("congregate", "To gather into a crowd or mass, especially for religious worship."),
            Map.entry("ordination", "The action of conferring holy orders on someone."),
            Map.entry("penitence", "The action of feeling or showing sorrow and regret for having done wrong."),
            Map.entry("reincarnate", "To be born again in another body.")
        ),
        Map.ofEntries(
            Map.entry("transubstantiation", "The belief in the transformation of the bread and wine "
                + "into the body and blood of Christ in the Eucharist."),
            Map.entry("predestination", "The doctrine that all events have been willed by God."),
            Map.entry("reconciliation", "The act of restoring friendly relations, especially between God and humans."),
            Map.entry("fundamentalism", "A strict adherence to the basic principles of any subject or discipline."),
            Map.entry("interdenominational", "Relating to multiple Christian denominations."),
            Map.entry("proselytization", "The act of converting someone to a different religion or faith."),
            Map.entry("ecclesiastical", "Relating to the Christian Church or its clergy."),
            Map.entry("eschatological", "Relating to death, judgment, and the final "
                + "destiny of the soul and of humankind."),
            Map.entry("excommunication", "The act of officially excluding someone"
                + " from participation in the sacraments and services of the Christian Church."),
            Map.entry("infallibility", "The belief that the Pope is incapable of error in matters of doctrine."),
            Map.entry("millenarianism", "Belief in a future thousand-year "
                + "age of blessedness, beginning with the Second Coming of Christ."),
            Map.entry("consubstantiation", "The belief that the substance of the bread"
                + " and wine coexists with the body and blood of Christ in the Eucharist."),
            Map.entry("dispensationalism", "A theological view that divides history into periods or dispensations."),
            Map.entry("evangelization", "The act of spreading the Christian gospel."),
            Map.entry("sanctification", "The process of becoming holy or being made holy.")
        )
    };

    public static String getWord(int theme, int level) {
        Random random = new Random();
        Map<String, String> chosenMap = switch (theme) {
            case THEME_WAR -> WORDS_WAR[level - 1];
            case THEME_DEV -> WORDS_DEV[level - 1];
            case THEME_RELIGION -> WORDS_RELIGION[level - 1];
            default -> WORDS_WAR[1];
        };

        String[] keys = chosenMap.keySet().toArray(new String[0]);
        return keys[random.nextInt(keys.length)];
    }

    public static String getHint(int theme, int level, String word) {
        Map<String, String> chosenMap = switch (theme) {
            case THEME_WAR -> WORDS_WAR[level - 1];
            case THEME_DEV -> WORDS_DEV[level - 1];
            case THEME_RELIGION -> WORDS_RELIGION[level - 1];
            default -> WORDS_WAR[1];
        };

        return chosenMap.getOrDefault(word, "Word not found in the specified theme and level.");
    }
}
