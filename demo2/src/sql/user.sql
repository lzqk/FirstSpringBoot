
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `isdelete` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `knowledge`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '科目',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `crtTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modfTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `knowledge` VALUES (1, '数学', '代数', '代数是研究数、数量、关系、结构与代数方程（组）的通用解法及其性质的数学分支。初等代数一般在中学时讲授，介绍代数的基本思想：研究当我们对数字作加法或乘法时会发生什么，以及了解变量的概念和如何建立多项式并找出它们的根。代数的研究对象不仅是数字，而是各种抽象化的结构。在其中我们只关心各种关系及其性质，而对于“数本身是什么”这样的问题并不关心。常见的代数结构类型有群、环、域、模、线性空间等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (2, '数学', '几何', '几何，就是研究空间结构及性质的一门学科。它是数学中最基本的研究内容之一，与分析、代数等等具有同样重要的地位，并且关系极为密切。几何学发展历史悠长，内容丰富。它和代数、分析、数论等等关系极其密切。几何思想是数学中最重要的一类思想。暂时的数学各分支发展都有几何化趋向，即用几何观点及思想方法去探讨各数学理论。常见定理有勾股定理，欧拉定理，斯图尔特定理等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (3, '数学', '概率', '概率亦称“或然率”。它反映随机事件出现的可能性（likelihood)大小。随机事件是指在相同条件下，可能出现也可能不出现的事件。例如，从一批有正品和次品的商品中，随意抽取一件，“抽得的是正品”就是一个随机事件。设对某一随机现象进行了n次试验与观察，其中A事件出现了m次，即其出现的频率为m/n。经过大量反复试验，常有m/n越来越接近于某个确定的常数（此论断证明详见伯努利大数定律）。该常数即为事件A出现的概率，常用P (A) 表示。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (4, '数学', '量子数学', '量子数学是指基于时间和空间的量子性而建立的数学，用于描述真实的物理世界。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (5, '物理学', '声', '物理中声音是由物体振动发生的，正在发声的物体叫做声源。物体在一秒钟之内振动的次数叫做频率，单位是赫兹，字母Hz.人的耳朵可以听到20Hz-----20000Hz的声音.最敏感是1000Hz-----3000Hz之间的声音。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (6, '物理学', '光', '光是一个物理学名词，其本质是一种处于特定频段的光子流。光源发出光，是因为光源中电子获得额外能量。如果能量不足以使其跃迁（jump）到更外层的轨道，电子就会进行加速运动，并以波的形式释放能量；反之，电子跃迁。如果跃迁之后刚好填补了所在轨道的空位，从激发态到达稳定态，电子就不动了；反之，电子会再次跃迁回之前的轨道，并且以波的形式释放能量。简单地说，光是沿直线传播的。在广义相对论中，由于光受到物体强引力场的影响，光的传播路径被发生相应的偏折。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (7, '物理学', '电', '电是一种自然现象，指电荷运动所带来的现象。自然界的闪电就是电的一种现象。电是像电子和质子这样的亚原子粒子之间产生的排斥力和吸引力的一种属性。它是自然界四种基本相互作用之一。电子运动现象有两种：我们把缺少电子的原子说为带正电荷，有多余电子的原子说为带负电荷。电是个一般术语，是静止或移动的电荷所产生的物理现象。在大自然里，电的机制给出了很多众所熟知的效应，例如闪电、摩擦起电、静电感应、电磁感应等等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (8, '物理学', '力', '力是力学中的基本概念之一，是使物体获得加速度或形变的外因。在动力学中它等于物体的质量与加速度的乘积。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (9, '物理学', '磁', '在电磁学里，当两块磁铁或磁石相互吸引或排斥时，或当载流导线在周围产生磁场，促使磁针偏转指向，或当闭电路移动于不均匀磁场时，会有电流出现于闭电路，这些都是与磁有关的现象。凡是与磁有关的现象也都会与磁场有关。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (10, '化学', '无机化学', '元素化学、无机合成化学、无机高分子化学、无机固体化学、配位化学（即络合物化学）、同位素化学、生物无机化学、金属有机化学、金属酶化学等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (11, '化学', '有机化学', '普通有机化学、有机合成化学、金属和非金属有机化学、物理有机化学、生物有机化学、有机分析化学。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (12, '化学', '物理化学', '结构化学、热化学、化学热力学、化学动力学、电化学、溶液理论、界面化学、胶体化学、量子化学、催化作用及其理论等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (13, '化学', '分析化学', '化学分析、仪器和新技术分析。包括性能测定、监控、各种光谱和光化学分析、各种电化学分析方法、质谱分析法、各种电镜、成像和形貌分析方法，在线分析、活性分析、实时分析等，各种物理化学性能和生理活性的检测方法，萃取、离子交换、色谱、质谱等分离方法，分离分析联用、合成分离分析三联用等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (14, '化学', '高分子化学', '天然高分子化学、高分子合成化学、高分子物理化学、高聚物应用、高分子物理。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (15, '化学', '核化学', '放射性元素化学、放射分析化学、辐射化学、同位素化学、核化学。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (16, '化学', '生物化学', '一般生物化学、酶类、微生物化学、植物化学、免疫化学、发酵和生物工程、食品化学、煤化学等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (17, '天体学和天体物理', '太阳学科', '研究太阳表面的各种现象、太阳内部结构、能量来源、化学组成等', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (18, '天体学和天体物理', '恒星学科', '研究各种恒星的性质、结构、物理状况、化学组成、起源和演化等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (19, '天体学和天体物理', '星系学科', '又称河外天文学，研究星系（包括银河系）、星系团、星系际空间等的形态、结构、运动、组成、物理性质等。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (20, '天体学和天体物理', '宇宙学科', '从整体的角度来研究宇宙的结构和演化。包括侧重于发现宇宙大尺度观测特征的观测宇宙学和侧重于研究宇宙的运动学和动力学以及建立宇宙模型的理论宇宙学。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (21, '天体学和天体物理', '其他学科', '有射电天文学、空间天文学、高能天体物理学、', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (22, '地球与空间科学', '地球与空间科学', '地球与空间科学专业以太阳系特别是日地空间物理环境作为主要研究对象，是应用性很强的基础专业，它的研究成果不仅有助于增进人类地球及其空间环境的科学认识，而且支持着众多的国民经济建设中具有重要意义的产业部门或高科技领域，为太空时代的人类活动提供了必要的基础。今天，地球与空间科学已成为地球科学中最具活力的学科之一，其研究成果将对21世纪人类的生存发展、太空环境的充分利用产生重要影响。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (23, '生命科学', '形态学', '形态学是生物学中研究动、植物形态结构的学科。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (24, '生命科学', '生理学', '生理学是研究生物机能的学科，生理学的研究方法是以实验为主。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (25, '生命科学', '遗传学', '遗传学是研究生物性状的遗传和变异，阐明其规律的学科。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (26, '生命科学', '胚胎学', '胚胎学是研究生物个体发育的学科，原属形态学范围。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (27, '生命科学', '生态学', '生态学是研究生物与生物之间以及生物与环境之间的关系的学科。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (28, '生命科学', '生物物理学', '生物物理学是用物理学的概念和方法研究生物的结构和功能、研究生命活动的物理和物理化学过程的学科。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (29, '生命科学', '生物数学', '生物数学是数学和生物学结合的产物。它的任务是用数学的方法研究生物学问题，研究生命过程的数学规\r\n生物数学\r\n生物数学\r\n律。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (30, '生命科学', '分子生物学', '分子生物学是研究分子层次的生命过程的学科。它的任务在于从分子的结构与功能以及分子之间的相互作用去揭示各种生命过程的物质基础。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
INSERT INTO `knowledge` VALUES (31, '生命科学', '细胞生物学', '细胞生物学是研究细胞层次生命过程的学科，早期称细胞学是以形态描述为主的。以后，细胞学吸收了分子生物学的成就，深入到超微结构的水平，主要研究细胞的生长、代谢和遗传等生物学过程，细胞学也就发展成细胞生物学了。', '2019-05-16 16:52:31', '2019-05-16 16:52:31');
