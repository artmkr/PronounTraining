-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: pronoun_training
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `core_pronouns`
--

DROP TABLE IF EXISTS `core_pronouns`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_pronouns` (
  `id`        INT(8)             NOT NULL AUTO_INCREMENT,
  `pronoun`   VARCHAR(250)
              CHARACTER SET utf8 NOT NULL,
  `is_plural` TINYINT(1)         NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pronoun_UNIQUE` (`pronoun`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_pronouns`
--

LOCK TABLES `core_pronouns` WRITE;
/*!40000 ALTER TABLE `core_pronouns`
  DISABLE KEYS */;
INSERT INTO `core_pronouns`
VALUES (1, 'he', 0), (2, 'she', 0), (3, 'it', 0), (4, 'they', 1), (5, 'we', 1), (6, 'you', 1);
/*!40000 ALTER TABLE `core_pronouns`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_verbs`
--

DROP TABLE IF EXISTS `core_verbs`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_verbs` (
  `id`            INT(8)                  NOT NULL AUTO_INCREMENT,
  `verb_plural`   VARCHAR(250)
                  CHARACTER SET utf8      NOT NULL,
  `verb_singular` VARCHAR(250)
                  COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `verb_singular_UNIQUE` (`verb_singular`),
  UNIQUE KEY `verb_plural_UNIQUE` (`verb_plural`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_verbs`
--

LOCK TABLES `core_verbs` WRITE;
/*!40000 ALTER TABLE `core_verbs`
  DISABLE KEYS */;
INSERT INTO `core_verbs` VALUES (1, 'do', 'does'), (2, 'have', 'has'), (3, 'are', 'is'), (4, 'were', 'was');
/*!40000 ALTER TABLE `core_verbs`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronouns`
--

DROP TABLE IF EXISTS `pronouns`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pronouns` (
  `id`        INT(8)             NOT NULL AUTO_INCREMENT,
  `pronoun`   VARCHAR(250)
              CHARACTER SET utf8 NOT NULL,
  `is_plural` TINYINT(1)         NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 182
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronouns`
--

LOCK TABLES `pronouns` WRITE;
/*!40000 ALTER TABLE `pronouns`
  DISABLE KEYS */;
INSERT INTO `pronouns`
VALUES (30, 'Who', 0), (31, 'Those', 1), (32, 'Something', 0), (33, 'Someone', 0), (34, 'Everything', 0),
  (35, 'Everyone', 0), (36, 'Anyone', 0), (37, 'That', 0), (38, 'It', 0), (39, 'This', 0), (40, 'What', 0),
  (41, 'Which', 0), (42, 'These', 1), (43, 'None', 1), (44, 'Some', 1), (45, 'Nothing', 0), (46, 'Charlotte', 0),
  (47, 'Isabella', 0), (48, 'Mia', 0), (49, 'Rose', 0), (50, 'Alice', 0), (51, 'Lucy', 0), (52, 'Elizabeth', 0),
  (53, 'Lydia', 0), (54, 'Emily', 0), (55, 'Jane', 0), (56, 'Clara', 0), (57, 'Anna', 0), (58, 'Julia', 0),
  (59, 'Zoe', 0), (60, 'Daisy', 0), (61, 'Oliver', 0), (62, 'Jack', 0), (63, 'Henry', 0), (64, 'Leo', 0),
  (65, 'Elijah', 0), (66, 'Sebastian', 0), (67, 'Ethan', 0), (68, 'Matthew', 0), (69, 'Benjamin', 0), (70, 'Xavier', 0),
  (71, 'Felix', 0), (72, 'Jacob', 0), (73, 'William', 0), (74, 'Thomas', 0), (75, 'Luke', 0), (76, 'Julian', 0),
  (77, 'John', 0), (78, 'James', 0), (79, 'David', 0), (80, 'Woman', 0), (81, 'Women', 1), (82, 'Child', 0),
  (83, 'Children', 1), (84, 'Tooth', 0), (85, 'Teeth', 1), (86, 'Foot', 0), (87, 'Feet', 1), (88, 'Person', 0),
  (89, 'People', 1), (90, 'Mouse', 0), (91, 'Mice', 1), (92, 'Goose', 0), (93, 'Geese', 1), (94, 'Knife', 0),
  (95, 'Knives', 1), (96, 'Wife', 0), (97, 'Wives', 1), (98, 'Life', 0), (99, 'Lives', 1), (100, 'Potato', 0),
  (101, 'Potatoes', 1), (102, 'Tomato', 0), (103, 'Tomatoes', 1), (104, 'Families', 1), (105, 'Computers', 1),
  (106, 'Years', 1), (107, 'Birds', 1), (108, 'Problems', 1), (109, 'Things', 1), (110, 'Communities', 1),
  (111, 'Players', 1), (112, 'Videos', 1), (113, 'Movies', 1), (114, 'Thoughts', 1), (115, 'Boyfriends', 1),
  (116, 'Strategies', 1), (117, 'Armies', 1), (118, 'Users', 1), (119, 'Teachers', 1), (120, 'Politics', 1),
  (121, 'Students', 1), (122, 'Drivers', 1), (123, 'Dealers', 1), (124, 'Phones', 1), (125, 'Opinions', 1),
  (126, 'Payments', 1), (127, 'Ads', 1), (128, 'Debts', 1), (129, 'Hotels', 1), (130, 'Actors', 1), (131, 'Viruses', 1),
  (132, 'Owners', 1), (133, 'Candidates', 1), (134, 'Employees', 1), (135, 'Employers', 1), (136, 'Guests', 1),
  (137, 'Leaders', 1), (138, 'Moms', 1), (139, 'Singers', 1), (140, 'Songs', 1), (141, 'Vehicles', 1),
  (142, 'Girls', 1), (143, 'Historians', 1), (144, 'Workers', 1), (145, 'Winners', 1), (146, 'Writers', 1),
  (147, 'Buyers', 1), (148, 'Names', 1), (149, 'Bosses', 1), (150, 'Answers', 1), (151, 'Pictures', 1),
  (152, 'Gardens', 1), (153, 'Images', 1), (154, 'Dogs', 1), (155, 'Cats', 1), (156, 'Wars', 1), (157, 'Boxes', 1),
  (158, 'Rooms', 1), (159, 'Balls', 1), (160, 'Tables', 1), (161, 'Machines', 1), (162, 'Stars', 1),
  (163, 'Couples', 1), (164, 'Sister', 0), (165, 'Apple', 0), (166, 'Assistant', 0), (167, 'Celebrity', 0),
  (168, 'Client', 0), (169, 'Girlfriend', 0), (170, 'Lady', 0), (171, 'Pizza', 0), (172, 'Poet', 0), (173, 'Sir', 0),
  (174, 'Speaker', 0), (175, 'Stranger', 0), (176, 'Uncle', 0), (177, 'Film', 0), (178, 'Business', 0),
  (179, 'Guide', 0), (180, 'School', 0), (181, 'Boss', 0);
/*!40000 ALTER TABLE `pronouns`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verbs`
--

DROP TABLE IF EXISTS `verbs`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verbs` (
  `id`            INT(8)                  NOT NULL AUTO_INCREMENT,
  `verb_plural`   VARCHAR(250)
                  CHARACTER SET utf8      NOT NULL,
  `verb_singular` VARCHAR(250)
                  COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1022
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verbs`
--

LOCK TABLES `verbs` WRITE;
/*!40000 ALTER TABLE `verbs`
  DISABLE KEYS */;
INSERT INTO `verbs` VALUES (1, 'work', 'works'), (2, 'sing', 'sings'), (3, 'dance', 'dances'), (4, 'drink', 'drinks'),
  (5, 'sleep', 'sleeps'), (6, 'eat', 'eats'), (7, 'speak', 'speaks'), (8, 'read', 'reads'), (9, 'write', 'writes'),
  (10, 'code', 'codes'), (11, 'walk', 'walks'), (12, 'run', 'runs'), (13, 'make', 'makes'), (14, 'think', 'thinks'),
  (15, 'play', 'plays'), (16, 'tell', 'tells'), (17, 'say', 'says'), (18, 'get', 'gets'), (19, 'see', 'sees'),
  (20, 'need', 'needs'), (21, 'know', 'knows'), (23, 'find', 'finds'), (24, 'take', 'takes'), (25, 'want', 'wants'),
  (26, 'learn', 'learns'), (27, 'become', 'becomes'), (28, 'come', 'comes'), (29, 'include', 'includes'),
  (30, 'thank', 'thanks'), (31, 'provide', 'provides'), (32, 'create', 'creates'), (33, 'add', 'adds'),
  (34, 'understand', 'understands'), (35, 'consider', 'considers'), (36, 'choose', 'chooses'),
  (37, 'develop', 'develops'), (38, 'remember', 'remembers'), (39, 'determine', 'determines'), (40, 'grow', 'grows'),
  (41, 'allow', 'allows'), (42, 'supply', 'supplies'), (43, 'bring', 'brings'), (44, 'improve', 'improves'),
  (45, 'maintain', 'maintains'), (46, 'begin', 'begins'), (47, 'exist', 'exists'), (48, 'tend', 'tends'),
  (49, 'enjoy', 'enjoys'), (50, 'perform', 'performs'), (51, 'decide', 'decides'), (53, 'continue', 'continues'),
  (54, 'protect', 'protects'), (55, 'require', 'requires'), (57, 'write', 'writes'), (58, 'approach', 'approaches'),
  (59, 'avoid', 'avoids'), (60, 'prepare', 'prepares'), (61, 'build', 'builds'), (62, 'achieve', 'achieves'),
  (63, 'believe', 'believes'), (64, 'receive', 'receives'), (65, 'seem', 'seems'), (66, 'discuss', 'discusses'),
  (67, 'realize', 'realizes'), (69, 'follow', 'follows'), (71, 'solve', 'solves'), (72, 'describe', 'describes'),
  (73, 'prefer', 'prefers'), (74, 'prevent', 'prevents'), (75, 'discover', 'discovers'), (76, 'ensure', 'ensures'),
  (77, 'expect', 'expects'), (78, 'invest', 'invests'), (79, 'reduce', 'reduces'), (80, 'speak', 'speaks'),
  (81, 'appear', 'appears'), (82, 'explain', 'explains'), (83, 'explore', 'explores'), (84, 'involve', 'involves'),
  (85, 'lose', 'loses'), (87, 'agree', 'agrees'), (88, 'hear', 'hears'), (89, 'remain', 'remains'),
  (90, 'represent', 'represents'), (91, 'apply', 'applies'), (92, 'forget', 'forgets'), (93, 'recommend', 'recommends'),
  (94, 'rely', 'relies'), (96, 'generate', 'generates'), (97, 'obtain', 'obtains'), (98, 'accept', 'accepts'),
  (99, 'communicate', 'communicates'), (100, 'complain', 'complains'), (101, 'depend', 'depends'),
  (102, 'enter', 'enters'), (105, 'suggest', 'suggests'), (106, 'survive', 'survives'),
  (107, 'appreciate', 'appreciates'), (108, 'compare', 'compares'), (109, 'imagine', 'imagines'),
  (110, 'manage', 'manages'), (112, 'encourage', 'encourages'), (114, 'prove', 'proves'), (115, 'react', 'reacts'),
  (116, 'recognize', 'recognizes'), (117, 'relax', 'relaxes'), (118, 'replace', 'replaces'), (119, 'borrow', 'borrows'),
  (120, 'earn', 'earns'), (121, 'emphasize', 'emphasizes'), (123, 'operate', 'operates'), (125, 'send', 'sends'),
  (126, 'anticipate', 'anticipates'), (127, 'assume', 'assumes'), (128, 'engage', 'engages'),
  (129, 'enhance', 'enhances'), (130, 'examine', 'examines'), (131, 'install', 'installs'),
  (132, 'participate', 'participates'), (133, 'intend', 'intends'), (134, 'introduce', 'introduces'),
  (135, 'relate', 'relates'), (136, 'settle', 'settles'), (137, 'assure', 'assures'), (138, 'attract', 'attracts'),
  (139, 'distribute', 'distributes'), (140, 'overcome', 'overcomes'), (141, 'owe', 'owes'), (143, 'suffer', 'suffers'),
  (144, 'throw', 'throws'), (145, 'acquire', 'acquires'), (146, 'adapt', 'adapts'), (147, 'adjust', 'adjusts'),
  (148, 'argue', 'argues'), (149, 'arise', 'arises'), (150, 'confirm', 'confirms'), (153, 'justify', 'justifies'),
  (154, 'organize', 'organizes'), (160, 'calculate', 'calculates'), (161, 'compete', 'competes'),
  (162, 'consult', 'consults'), (163, 'deliver', 'delivers'), (164, 'extend', 'extends'),
  (165, 'investigate', 'investigates'), (166, 'negotiate', 'negotiates'), (167, 'qualify', 'qualifies'),
  (168, 'retire', 'retires'), (169, 'rid', 'rids'), (170, 'weigh', 'weighs'), (171, 'arrive', 'arrives'),
  (172, 'attach', 'attaches'), (173, 'behave', 'behaves'), (174, 'celebrate', 'celebrates'),
  (175, 'convince', 'convinces'), (176, 'disagree', 'disagrees'), (177, 'establish', 'establishes'),
  (178, 'ignore', 'ignores'), (179, 'imply', 'implies'), (180, 'insist', 'insists'), (181, 'pursue', 'pursues'),
  (183, 'specify', 'specifies'), (184, 'warn', 'warns'), (185, 'accuse', 'accuses'), (186, 'admire', 'admires'),
  (187, 'admit', 'admits'), (188, 'adopt', 'adopts'), (189, 'announce', 'announces'), (190, 'apologize', 'apologizes'),
  (191, 'approve', 'approves'), (192, 'attend', 'attends'), (193, 'belong', 'belongs'), (194, 'commit', 'commits'),
  (195, 'criticize', 'criticizes'), (196, 'deserve', 'deserves'), (197, 'destroy', 'destroys'),
  (198, 'hesitate', 'hesitates'), (199, 'illustrate', 'illustrates'), (200, 'inform', 'informs'),
  (202, 'persuade', 'persuades'), (203, 'pour', 'pours'), (204, 'propose', 'proposes'), (205, 'remind', 'reminds'),
  (207, 'submit', 'submits'), (208, 'suppose', 'supposes'), (209, 'translate', 'translates'), (211, 'use', 'uses'),
  (212, 'make', 'makes'), (213, 'look', 'looks'), (214, 'help', 'helps'), (215, 'go', 'goes'), (219, 'keep', 'keeps'),
  (220, 'start', 'starts'), (221, 'give', 'gives'), (222, 'play', 'plays'), (223, 'feel', 'feels'),
  (224, 'put', 'puts'), (225, 'set', 'sets'), (226, 'change', 'changes'), (227, 'say', 'says'), (228, 'cut', 'cuts'),
  (229, 'show', 'shows'), (230, 'try', 'tries'), (231, 'check', 'checks'), (232, 'call', 'calls'),
  (233, 'move', 'moves'), (234, 'pay', 'pays'), (235, 'let', 'lets'), (236, 'increase', 'increases'),
  (237, 'turn', 'turns'), (238, 'ask', 'asks'), (239, 'buy', 'buys'), (240, 'guard', 'guards'), (241, 'hold', 'holds'),
  (242, 'offer', 'offers'), (243, 'travel', 'travels'), (244, 'cook', 'cooks'), (245, 'dance', 'dances'),
  (247, 'live', 'lives'), (248, 'purchase', 'purchases'), (249, 'deal', 'deals'), (250, 'mean', 'means'),
  (251, 'fall', 'falls'), (252, 'produce', 'produces'), (253, 'search', 'searches'), (254, 'spend', 'spends'),
  (255, 'talk', 'talks'), (256, 'upset', 'upsets'), (257, 'tell', 'tells'), (258, 'cost', 'costs'),
  (259, 'drive', 'drives'), (260, 'support', 'supports'), (261, 'remove', 'removes'), (262, 'return', 'returns'),
  (263, 'run', 'runs'), (264, 'appropriate', 'appropriates'), (265, 'reserve', 'reserves'), (266, 'leave', 'leaves'),
  (267, 'reach', 'reaches'), (268, 'rest', 'rests'), (269, 'serve', 'serves'), (270, 'watch', 'watches'),
  (271, 'charge', 'charges'), (272, 'break', 'breaks'), (273, 'stay', 'stays'), (274, 'visit', 'visits'),
  (275, 'affect', 'affects'), (276, 'cover', 'covers'), (277, 'report', 'reports'), (278, 'rise', 'rises'),
  (279, 'walk', 'walks'), (280, 'pick', 'picks'), (281, 'lift', 'lifts'), (282, 'mix', 'mixes'), (283, 'stop', 'stops'),
  (284, 'teach', 'teaches'), (285, 'concern', 'concerns'), (286, 'fly', 'flies'), (288, 'gain', 'gains'),
  (289, 'save', 'saves'), (290, 'stand', 'stands'), (291, 'fail', 'fails'), (292, 'lead', 'leads'),
  (293, 'listen', 'listens'), (294, 'worry', 'worries'), (295, 'express', 'expresses'), (296, 'handle', 'handles'),
  (298, 'release', 'releases'), (299, 'sell', 'sells'), (300, 'finish', 'finishes'), (301, 'press', 'presses'),
  (302, 'ride', 'rides'), (303, 'spread', 'spreads'), (305, 'wait', 'waits'), (306, 'display', 'displays'),
  (307, 'flow', 'flows'), (308, 'hit', 'hits'), (309, 'shoot', 'shoots'), (310, 'touch', 'touches'),
  (311, 'cancel', 'cancels'), (312, 'cry', 'cries'), (313, 'dump', 'dumps'), (314, 'push', 'pushes'),
  (315, 'select', 'selects'), (317, 'die', 'dies'), (318, 'eat', 'eats'), (319, 'fill', 'fills'),
  (320, 'jump', 'jumps'), (321, 'kick', 'kicks'), (322, 'pass', 'passes'), (324, 'treat', 'treats'),
  (325, 'abuse', 'abuses'), (326, 'beat', 'beats'), (327, 'burn', 'burns'), (328, 'deposit', 'deposits'),
  (329, 'print', 'prints'), (330, 'raise', 'raises'), (331, 'sleep', 'sleeps'), (332, 'advance', 'advances'),
  (333, 'connect', 'connects'), (334, 'consist', 'consists'), (335, 'contribute', 'contributes'),
  (336, 'draw', 'draws'), (337, 'fix', 'fixes'), (338, 'hire', 'hires'), (339, 'join', 'joins'), (340, 'kill', 'kills'),
  (341, 'sit', 'sits'), (342, 'tap', 'taps'), (343, 'win', 'wins'), (344, 'attack', 'attacks'),
  (345, 'claim', 'claims'), (346, 'drag', 'drags'), (347, 'drink', 'drinks'), (348, 'guess', 'guesses'),
  (349, 'pull', 'pulls'), (350, 'wear', 'wears'), (351, 'wonder', 'wonders'), (352, 'count', 'counts'),
  (353, 'doubt', 'doubts'), (354, 'feed', 'feeds'), (355, 'impress', 'impresses'), (356, 'repeat', 'repeats'),
  (357, 'seek', 'seeks'), (358, 'sing', 'sings'), (359, 'slide', 'slides'), (360, 'strip', 'strips'),
  (361, 'wish', 'wishes'), (362, 'collect', 'collects'), (363, 'combine', 'combines'), (364, 'command', 'commands'),
  (365, 'dig', 'digs'), (367, 'hang', 'hangs'), (368, 'hunt', 'hunts'), (370, 'mention', 'mentions'),
  (371, 'smell', 'smells'), (372, 'survey', 'surveys'), (373, 'tie', 'ties'), (374, 'escape', 'escapes'),
  (375, 'expose', 'exposes'), (376, 'gather', 'gathers'), (377, 'hate', 'hates'), (378, 'repair', 'repairs'),
  (379, 'scratch', 'scratches'), (380, 'strike', 'strikes'), (381, 'employ', 'employs'), (382, 'hurt', 'hurts'),
  (383, 'laugh', 'laughs'), (384, 'lay', 'lays'), (385, 'respond', 'responds'), (386, 'split', 'splits'),
  (387, 'strain', 'strains'), (388, 'struggle', 'struggles'), (389, 'swim', 'swims'), (390, 'train', 'trains'),
  (391, 'wash', 'washes'), (392, 'waste', 'wastes'), (393, 'convert', 'converts'), (394, 'crash', 'crashes'),
  (395, 'fold', 'folds'), (396, 'grab', 'grabs'), (397, 'hide', 'hides'), (398, 'miss', 'misses'),
  (399, 'permit', 'permits'), (400, 'quote', 'quotes'), (401, 'recover', 'recovers'), (402, 'resolve', 'resolves'),
  (403, 'roll', 'rolls'), (404, 'sink', 'sinks'), (405, 'slip', 'slips'), (406, 'suspect', 'suspects'),
  (407, 'swing', 'swings'), (408, 'twist', 'twists'), (409, 'concentrate', 'concentrates'),
  (410, 'estimate', 'estimates'), (412, 'refuse', 'refuses'), (413, 'regret', 'regrets'), (414, 'reveal', 'reveals'),
  (415, 'rush', 'rushes'), (416, 'shake', 'shakes'), (418, 'shine', 'shines'), (419, 'steal', 'steals'),
  (420, 'suck', 'sucks'), (421, 'surround', 'surrounds'), (423, 'dare', 'dares'), (424, 'delay', 'delays'),
  (425, 'hurry', 'hurries'), (426, 'invite', 'invites'), (427, 'kiss', 'kisses'), (428, 'marry', 'marries'),
  (430, 'pray', 'prays'), (431, 'pretend', 'pretends'), (432, 'punch', 'punches'), (433, 'quit', 'quits'),
  (434, 'reply', 'replies'), (435, 'resist', 'resists'), (437, 'rub', 'rubs'), (438, 'smile', 'smiles'),
  (439, 'spell', 'spells'), (440, 'stretch', 'stretches'), (441, 'tear', 'tears'), (444, 'like', 'likes'),
  (446, 'film', 'films'), (447, 'water', 'waters'), (452, 'study', 'studies'), (456, 'place', 'places'),
  (457, 'number', 'numbers'), (460, 'fish', 'fishes'), (463, 'hand', 'hands'), (464, 'experience', 'experiences'),
  (468, 'point', 'points'), (469, 'type', 'types'), (470, 'value', 'values'), (484, 'trade', 'trades'),
  (486, 'care', 'cares'), (490, 'force', 'forces'), (492, 'name', 'names'), (495, 'order', 'orders'),
  (496, 'practice', 'practices'), (497, 'research', 'researches'), (498, 'sense', 'senses'), (506, 'test', 'tests'),
  (507, 'answer', 'answers'), (508, 'sound', 'sounds'), (509, 'focus', 'focuses'), (510, 'matter', 'matters'),
  (516, 'garden', 'gardens'), (517, 'open', 'opens'), (519, 'rate', 'rates'), (520, 'reason', 'reasons'),
  (523, 'demand', 'demands'), (524, 'exercise', 'exercises'), (527, 'cause', 'causes'), (529, 'age', 'ages'),
  (531, 'record', 'records'), (538, 'dry', 'dries'), (539, 'plan', 'plans'), (540, 'store', 'stores'),
  (545, 'rule', 'rules'), (556, 'question', 'questions'), (557, 'rock', 'rocks'), (558, 'act', 'acts'),
  (564, 'fit', 'fits'), (565, 'note', 'notes'), (566, 'profit', 'profits'), (570, 'style', 'styles'),
  (576, 'exchange', 'exchanges'), (580, 'pressure', 'pressures'), (583, 'benefit', 'benefits'),
  (586, 'frame', 'frames'), (591, 'face', 'faces'), (594, 'paint', 'paints'), (595, 'review', 'reviews'),
  (599, 'view', 'views'), (605, 'share', 'shares'), (613, 'shape', 'shapes'), (616, 'address', 'addresses'),
  (621, 'sign', 'signs'), (625, 'contact', 'contacts'), (628, 'hope', 'hopes'), (632, 'attempt', 'attempts'),
  (637, 'post', 'posts'), (645, 'debate', 'debates'), (646, 'exit', 'exits'), (648, 'function', 'functions'),
  (649, 'lack', 'lacks'), (650, 'plant', 'plants'), (651, 'spot', 'spots'), (653, 'taste', 'tastes'),
  (655, 'track', 'tracks'), (659, 'click', 'clicks'), (660, 'correct', 'corrects'), (661, 'desire', 'desires'),
  (665, 'influence', 'influences'), (666, 'notice', 'notices'), (670, 'damage', 'damages'), (675, 'target', 'targets'),
  (676, 'text', 'texts'), (685, 'reference', 'references'), (686, 'register', 'registers'), (702, 'lock', 'locks'),
  (705, 'pack', 'packs'), (706, 'park', 'parks'), (709, 'sort', 'sorts'), (710, 'weight', 'weights'),
  (712, 'carry', 'carries'), (723, 'land', 'lands'), (730, 'wave', 'waves'), (735, 'copy', 'copies'),
  (736, 'drop', 'drops'), (749, 'dream', 'dreams'), (755, 'limit', 'limits'), (771, 'catch', 'catches'),
  (772, 'chain', 'chains'), (782, 'pleasure', 'pleasures'), (787, 'shop', 'shops'), (794, 'block', 'blocks'),
  (805, 'guarantee', 'guarantees'), (808, 'implement', 'implements'), (811, 'lie', 'lies'),
  (817, 'respect', 'respects'), (821, 'tip', 'tips'), (823, 'battle', 'battles'), (828, 'code', 'codes'),
  (832, 'farm', 'farms'), (833, 'fight', 'fights'), (840, 'mistake', 'mistakes'), (841, 'nail', 'nails'),
  (847, 'race', 'races'), (848, 'sand', 'sands'), (851, 'smoke', 'smokes'), (852, 'stomach', 'stomaches'),
  (860, 'bet', 'bets'), (876, 'iron', 'irons'), (877, 'judge', 'judges'), (878, 'knife', 'knifes'),
  (881, 'mail', 'mails'), (893, 'tackle', 'tackles'), (895, 'trust', 'trusts'), (896, 'assist', 'assists'),
  (897, 'bake', 'bakes'), (900, 'bike', 'bikes'), (901, 'blame', 'blames'), (907, 'comment', 'comments'),
  (911, 'fear', 'fears'), (912, 'fuel', 'fuels'), (916, 'monitor', 'monitors'), (920, 'panic', 'panics'),
  (921, 'peak', 'peaks'), (923, 'reward', 'rewards'), (928, 'spray', 'sprays'), (929, 'surprise', 'surprises'),
  (934, 'alarm', 'alarms'), (935, 'bend', 'bends'), (936, 'bicycle', 'bicycles'), (937, 'bite', 'bites'),
  (949, 'harm', 'harms'), (950, 'knee', 'knees'), (952, 'load', 'loads'), (960, 'ruin', 'ruins'),
  (963, 'slice', 'slices'), (966, 'switch', 'switches'), (968, 'trash', 'trashes'), (973, 'award', 'awards'),
  (974, 'bid', 'bids'), (975, 'boot', 'boots'), (976, 'bug', 'bugs'), (977, 'camp', 'camps'),
  (994, 'highlight', 'highlights'), (996, 'joke', 'jokes'), (1008, 'ring', 'rings'), (1011, 'sail', 'sails'),
  (1021, 'witness', 'witnesses');
/*!40000 ALTER TABLE `verbs`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2017-04-17  0:59:15
